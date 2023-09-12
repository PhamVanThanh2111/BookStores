import pygame
import random

# Khởi tạo màu sắc
BLACK = (0, 0, 0)
WHITE = (255, 255, 255)
CYAN = (0, 255, 255)
YELLOW = (255, 255, 0)
PURPLE = (255, 0, 255)
GREEN = (0, 255, 0)
RED = (255, 0, 0)
ORANGE = (255, 165, 0)
BLUE = (0, 0, 255)

# Khởi tạo kích thước cửa sổ
WIDTH = 800
HEIGHT = 600

# Khởi tạo kích thước ô vuông và biến trò chơi
BLOCK_SIZE = 30
GRID_WIDTH = WIDTH // BLOCK_SIZE
GRID_HEIGHT = HEIGHT // BLOCK_SIZE

# Khởi tạo bảng điểm
score = 0

def draw_grid():
    for x in range(0, WIDTH, BLOCK_SIZE):
        pygame.draw.line(screen, WHITE, (x, 0), (x, HEIGHT))
    for y in range(0, HEIGHT, BLOCK_SIZE):
        pygame.draw.line(screen, WHITE, (0, y), (WIDTH, y))

def draw_tetromino(tetromino, grid_x, grid_y, color):
    for row in range(len(tetromino)):
        for col in range(len(tetromino[row])):
            if tetromino[row][col]:
                pygame.draw.rect(screen, color, (grid_x + col * BLOCK_SIZE, grid_y + row * BLOCK_SIZE, BLOCK_SIZE, BLOCK_SIZE))

def check_collision(tetromino, grid_x, grid_y, grid):
    for row in range(len(tetromino)):
        for col in range(len(tetromino[row])):
            if tetromino[row][col]:
                if grid_y + row >= GRID_HEIGHT or grid_x + col < 0 or grid_x + col >= GRID_WIDTH or grid[grid_y + row][grid_x + col]:
                    return True
    return False

def rotate_tetromino(tetromino):
    return list(zip(*reversed(tetromino)))

def clear_rows(grid):
    full_rows = []
    for row in range(GRID_HEIGHT):
        if all(grid[row]):
            full_rows.append(row)

    for row in full_rows:
        del grid[row]
        grid.insert(0, [0] * GRID_WIDTH)

    return len(full_rows)

def draw_score():
    font = pygame.font.SysFont(None, 36)
    text = font.render("Score: " + str(score), True, WHITE)
    screen.blit(text, (20, 20))

def reset_game():
    global falling_tetromino, falling_color, falling_x, falling_y, falling_rotation, grid, score, game_over

    falling_tetromino = None
    falling_color = None
    falling_x = 0
    falling_y = 0
    falling_rotation = 0

    grid = [[0] * GRID_WIDTH for _ in range(GRID_HEIGHT)]
    score = 0
    game_over = False


pygame.init()
screen = pygame.display.set_mode((WIDTH, HEIGHT))
pygame.display.set_caption("Tetris")

grid = [[0] * GRID_WIDTH for _ in range(GRID_HEIGHT)]
falling_tetromino = None
falling_color = None
falling_x = 0
falling_y = 0
falling_rotation = 0

clock = pygame.time.Clock()
game_over = False
game_quit = False

tetrominos = [
    [[1, 1, 1, 1]],
    [[1, 1], 
     [1, 1]],
    [[1, 1, 1], 
     [0, 1, 0]],
    [[1, 1, 1],
     [1, 0, 0]],
    [[1, 1, 1],
     [0, 0, 1]],
    [[1, 1, 0],
     [0, 1, 1]],
    [[0, 1, 1],
     [1, 1, 0]]
]

while not game_quit:
    while game_over:
        screen.fill(BLACK)
        font = pygame.font.SysFont(None, 72)
        text = font.render("Game Over", True, WHITE)
        screen.blit(text, (WIDTH//2 - text.get_width() // 2, HEIGHT//2 - text.get_height() // 2))
        pygame.display.flip()

        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                game_quit = True
                game_over = False
            elif event.type == pygame.KEYDOWN:
                if event.key == pygame.K_ESCAPE:
                    game_quit = True
                    game_over = False
        
        text = font.render("Game Over", True, WHITE)
        screen.blit(text, (WIDTH//2 - text.get_width() // 2, HEIGHT//2 - text.get_height() // 2))
        play_again_text = font.render("Press SPACE to play again", True, WHITE)
        screen.blit(play_again_text, (WIDTH//2 - play_again_text.get_width() // 2, HEIGHT//2 + text.get_height()))

        pygame.display.flip()

        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                game_quit = True
                game_over = False
            elif event.type == pygame.KEYDOWN:
                if event.key == pygame.K_ESCAPE:
                    game_quit = True
                    game_over = False
                elif event.key == pygame.K_SPACE:
                    reset_game()
    if not falling_tetromino:
        falling_tetromino = random.choice(tetrominos)
        falling_color = random.choice([CYAN, YELLOW, PURPLE, GREEN, RED, ORANGE, BLUE])
        falling_x = GRID_WIDTH // 2 - len(falling_tetromino[0]) // 2
        falling_y = 0
        falling_rotation = 0

        if check_collision(falling_tetromino, falling_x, falling_y, grid):
            game_over = True

    screen.fill(BLACK)
    draw_grid()
    draw_tetromino(falling_tetromino, falling_x * BLOCK_SIZE, falling_y * BLOCK_SIZE, falling_color)

    for row in range(len(grid)):
        for col in range(len(grid[row])):
            if grid[row][col]:
                pygame.draw.rect(screen, WHITE, (col * BLOCK_SIZE, row * BLOCK_SIZE, BLOCK_SIZE, BLOCK_SIZE))

    pygame.display.flip()

    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            game_quit = True
        elif event.type == pygame.KEYDOWN:
            if event.key == pygame.K_ESCAPE:
                game_quit = True
            elif event.key == pygame.K_LEFT:
                if not check_collision(falling_tetromino, falling_x - 1, falling_y, grid):
                    falling_x -= 1
            elif event.key == pygame.K_RIGHT:
                if not check_collision(falling_tetromino, falling_x + 1, falling_y, grid):
                    falling_x += 1
            elif event.key == pygame.K_DOWN:
                if not check_collision(falling_tetromino, falling_x, falling_y + 1, grid):
                    falling_y += 1
            elif event.key == pygame.K_UP:
                rotated = rotate_tetromino(falling_tetromino)
                if not check_collision(rotated, falling_x, falling_y, grid):
                    falling_tetromino = rotated

    if not check_collision(falling_tetromino, falling_x, falling_y + 1, grid):
        falling_y += 1
    else:
        for row in range(len(falling_tetromino)):
            for col in range(len(falling_tetromino[row])):
                if falling_tetromino[row][col]:
                    grid[falling_y + row][falling_x + col] = 1

        num_cleared_rows = clear_rows(grid)
        score += num_cleared_rows * num_cleared_rows

        falling_tetromino = None

    clock.tick(10)

pygame.quit()

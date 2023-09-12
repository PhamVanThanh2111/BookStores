import pygame
import random

# Khởi tạo kích thước màn hình
WIDTH = 800
HEIGHT = 600

# Khởi tạo màu sắc
WHITE = (255, 255, 255)
BLACK = (0, 0, 0)
RED = (255, 0, 0)
GREEN = (0, 255, 0)


# Khởi tạo pygame
pygame.init()
screen = pygame.display.set_mode((WIDTH, HEIGHT))
pygame.display.set_caption("Game Rắn")
clock = pygame.time.Clock()

# # Đường dẫn tới file biểu tượng
# icon_path = "./Screenshot 2022-11-05 101905.png"

# # Tạo và thiết lập icon
# icon = pygame.image.load(icon_path)
# pygame.display.set_icon(icon)

# Khởi tạo các biến game
block_size = 20
snake_speed = 20

font = pygame.font.SysFont(None, 30)

def draw_snake(block_size, snake_body):
    for block in snake_body:
        pygame.draw.rect(screen, GREEN, [block[0], block[1], block_size, block_size])

def game_loop():
    game_over = False
    game_exit = False

    # Khởi tạo tọa độ ban đầu cho rắn
    x = WIDTH / 2
    y = HEIGHT / 2

    x_change = 0
    y_change = 0

    snake_body = []
    snake_length = 1

    # Khởi tạo tọa độ thức ăn ban đầu
    food_x = round(random.randrange(0, WIDTH - block_size) / 20.0) * 20.0
    food_y = round(random.randrange(0, HEIGHT - block_size) / 20.0) * 20.0

    while not game_exit:
        while game_over:
            screen.fill(BLACK)
            message = font.render("Ban da thua! Nhan R de choi lai hoac nhan Q de thoat.", True, RED)
            screen.blit(message, [WIDTH / 6, HEIGHT / 3])
            pygame.display.update()
            
            for event in pygame.event.get():
                if event.type == pygame.QUIT:
                    game_exit = True
                    game_over = False
                if event.type == pygame.KEYDOWN:
                    if event.key == pygame.K_q:
                        game_exit = True
                        game_over = False
                    if event.key == pygame.K_r:
                        game_loop()

        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                game_exit = True
            if event.type == pygame.KEYDOWN:
                if event.key == pygame.K_LEFT:
                    x_change = -block_size
                    y_change = 0
                elif event.key == pygame.K_RIGHT:
                    x_change = block_size
                    y_change = 0
                elif event.key == pygame.K_UP:
                    y_change = -block_size
                    x_change = 0
                elif event.key == pygame.K_DOWN:
                    y_change = block_size
                    x_change = 0

        # Cập nhật tọa độ của rắn
        x += x_change
        y += y_change

        # Kiểm tra va chạm với tường
        if x >= WIDTH or x < 0 or y >= HEIGHT or y < 0:
            game_over = True

        screen.fill(BLACK)
        pygame.draw.rect(screen, RED, [food_x, food_y, block_size, block_size])

        # Cập nhật độ dài rắn
        snake_head = []
        snake_head.append(x)
        snake_head.append(y)
        snake_body.append(snake_head)

        if len(snake_body) > snake_length:
            del snake_body[0]

        # Kiểm tra va chạm với chính nó
        for segment in snake_body[:-1]:
            if segment == snake_head:
                game_over = True

        # Vẽ rắn
        draw_snake(block_size, snake_body)

        pygame.display.update()

        # Kiểm tra ăn thức ăn
        if x == food_x and y == food_y:
            food_x = round(random.randrange(0, WIDTH - block_size) / 20.0) * 20.0
            food_y = round(random.randrange(0, HEIGHT - block_size) / 20.0) * 20.0
            snake_length += 1

        clock.tick(snake_speed)
    pygame.quit()
game_loop()
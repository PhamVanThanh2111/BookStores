import pygame
pygame.init()
screen = pygame.display.set_mode([500, 600])
# screen.fill([255, 255, 255])
GREY = (150,150,150)
WHITE = (255,255,255) #Trắng, đem (0,0,0)
running = True
while running:
        screen.fill(GREY)

        pygame.draw.rect(screen, WHITE, (100,50,50,50))# Hàm vẽ hình chữ nhật
        pygame.draw.rect(screen, WHITE, (100,200,50,50))
        pygame.draw.rect(screen, WHITE, (200,50,50,50))
        # pygame.draw.rect(screen, WHITE, (200,200,50,50))
        # pygame.draw.rect(screen, WHITE, (300,50,50,50))
        # pygame.draw.rect(screen, WHITE, (300,200,50,50))
        # pygame.draw.rect(screen, WHITE, (400,50,50,50))
        # pygame.draw.rect(screen, WHITE, (400,200,50,50))
        # pygame.draw.rect(screen, WHITE, (100,350,50,50))
        # pygame.draw.rect(screen, WHITE, (100,500,50,50))
        # pygame.draw.rect(screen, WHITE, (200,350,50,50))
        # pygame.draw.rect(screen, WHITE, (200,500,50,50))
        # pygame.draw.rect(screen, WHITE, (300,350,50,50))
        # pygame.draw.rect(screen, WHITE, (300,500,50,50))
        # pygame.draw.rect(screen, WHITE, (400,350,50,50))
        # pygame.draw.rect(screen, WHITE, (400,500,50,50))
        

        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                running = False
            if event.type == pygame.MOUSEBUTTONDOWN: 
                if event.button == 1:
                    print("XXX")


        pygame.display.flip()
pygame.quit()
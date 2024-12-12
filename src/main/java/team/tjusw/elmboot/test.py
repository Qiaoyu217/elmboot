import pygame
import random
import sys

# Initialize pygame
pygame.init()

# Constants
SCREEN_WIDTH = 300
SCREEN_HEIGHT = 600
BLOCK_SIZE = 30
FPS = 10

# Colors
WHITE = (255, 255, 255)
BLUE = (0, 0, 255)
CYAN = (0, 255, 255)
ORANGE = (255, 165, 0)
YELLOW = (255, 255, 0)
GREEN = (0, 255, 0)
RED = (255, 0, 0)
PURPLE = (128, 0, 128)
LIGHT_BLUE = (0, 128, 255)

COLORS = [CYAN, BLUE, ORANGE, YELLOW, GREEN, RED, PURPLE]

# Tetriminos shapes
TETRIMINOS = [
    [[1, 1, 1, 1]],  # I
    [[1, 1, 1],
     [0, 1, 0]],     # T
    [[1, 1],
     [1, 1]],        # O
    [[0, 1, 1],
     [1, 1, 0]],     # S
    [[1, 1, 0],
     [0, 1, 1]],     # Z
    [[1, 0, 0],
     [1, 1, 1]],     # J
    [[0, 0, 1],
     [1, 1, 1]],     # L
]

# Game settings
screen = pygame.display.set_mode((SCREEN_WIDTH, SCREEN_HEIGHT))
pygame.display.set_caption("Tetris")

# Helper functions
def check_collision(board, shape, offset):
    off_x, off_y = offset
    for y, row in enumerate(shape):
        for x, cell in enumerate(row):
            if cell:
                try:
                    if board[y + off_y][x + off_x]:
                        return True
                except IndexError:
                    return True
                except Exception:
                    return True
    return False

def rotate_shape(shape):
    return [list(row) for row in zip(*shape[::-1])]

def clear_lines(board):
    new_board = [row for row in board if not all(cell == 0 for cell in row)]
    lines_cleared = len(board) - len(new_board)
    new_board = [[0] * (SCREEN_WIDTH // BLOCK_SIZE) for _ in range(lines_cleared)] + new_board
    return new_board, lines_cleared

# Game class
class Tetris:
    def __init__(self):
        self.board = [[0] * (SCREEN_WIDTH // BLOCK_SIZE) for _ in range(SCREEN_HEIGHT // BLOCK_SIZE)]
        self.gameover = False
        self.score = 0
        self.current_tetrimino = None
        self.current_position = None
        self.next_tetrimino = random.choice(TETRIMINOS)
        self.clock = pygame.time.Clock()

    def new_tetrimino(self):
        self.current_tetrimino = self.next_tetrimino
        self.current_position = [SCREEN_WIDTH // BLOCK_SIZE // 2 - len(self.current_tetrimino[0]) // 2, 0]
        self.next_tetrimino = random.choice(TETRIMINOS)
        if check_collision(self.board, self.current_tetrimino, self.current_position):
            self.gameover = True

    def move_tetrimino(self, dx, dy):
        new_position = [self.current_position[0] + dx, self.current_position[1] + dy]
        if not self.gameover and not check_collision(self.board, self.current_tetrimino, new_position):
            self.current_position = new_position
        elif dy > 0 and not self.gameover:
            self.lock_tetrimino()

    def lock_tetrimino(self):
        off_x, off_y = self.current_position
        for y, row in enumerate(self.current_tetrimino):
            for x, cell in enumerate(row):
                if cell:
                    self.board[off_y + y][off_x + x] = cell
        self.board, lines_cleared = clear_lines(self.board)
        self.score += lines_cleared * 100
        if check_collision(self.board, self.current_tetrimino, self.current_position):
            self.gameover = True
        else:
            self.new_tetrimino()

    def rotate_tetrimino(self):
        rotated = rotate_shape(self.current_tetrimino)
        if not check_collision(self.board, rotated, self.current_position):
            self.current_tetrimino = rotated

    def draw(self):
        if self.gameover:
            screen.fill((0, 0, 0))
        draw_board(self.board)
        draw_shape(self.current_tetrimino, self.current_position)
        pygame.display.update()

    def run(self):
        self.new_tetrimino()
        while not self.gameover:
            self.clock.tick(FPS)
            self.handle_input()
            if not self.gameover:
                self.move_tetrimino(0, 1)
                self.draw()

    def handle_input(self):
        key_actions = {
            pygame.K_LEFT: lambda: self.move_tetrimino(-1, 0),
            pygame.K_RIGHT: lambda: self.move_tetrimino(1, 0),
            pygame.K_DOWN: lambda: self.move_tetrimino(0, 1),
            pygame.K_UP: lambda: self.rotate_tetrimino()
        }

        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                self.gameover = True
                return
            if event.type == pygame.KEYDOWN and not self.gameover:
                if event.key in key_actions:
                    key_actions[event.key]()

def draw_board(board):
    for y, row in enumerate(board):
        for x, cell in enumerate(row):
            if 0 <= cell < len(COLORS):
                pygame.draw.rect(screen, COLORS[cell], (x * BLOCK_SIZE, y * BLOCK_SIZE, BLOCK_SIZE, BLOCK_SIZE))
            pygame.draw.rect(screen, WHITE, (x * BLOCK_SIZE, y * BLOCK_SIZE, BLOCK_SIZE, BLOCK_SIZE), 1)

def draw_shape(shape, offset):
    off_x, off_y = offset
    for y, row in enumerate(shape):
        for x, cell in enumerate(row):
            if cell:
                pygame.draw.rect(screen, COLORS[shape[y][x]], (off_x + x * BLOCK_SIZE, off_y + y * BLOCK_SIZE, BLOCK_SIZE, BLOCK_SIZE))

if __name__ == "__main__":
    game = Tetris()
    game.run()
    pygame.quit()
    sys.exit(0)

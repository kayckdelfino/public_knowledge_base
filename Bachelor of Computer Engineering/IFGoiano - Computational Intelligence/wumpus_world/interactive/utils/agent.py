class Agent:
    def __init__(self):
        # Posição inicial do agente
        self.x: int = 0
        self.y: int = 0

        # Recursos e pontuação
        self.gold: int = 0
        self.arrows: int = 8
        self.score: int = 0

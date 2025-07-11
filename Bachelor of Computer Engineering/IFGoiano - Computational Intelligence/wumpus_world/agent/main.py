from utils.environment import World
from utils.agent import Agent
from utils.logger import Logger

VALID_ACTIONS = {"w", "a", "s", "d", "pick", "shoot", "climb"}


def draw_world(world: World, agent: Agent, visited: set) -> str:
    output = ""
    for y in range(world.size - 1, -1, -1):
        row = ""
        for x in range(world.size):
            coord = (x, y)

            # 1) Posição do agente
            if coord == (agent.x, agent.y):
                cell = " A "
                visited.add(coord)

            # 2) Debug: sempre mostra conteúdo real
            elif world.debug:
                items = world.grid[y][x]
                if "wumpus" in items:
                    cell = " W "
                elif "pit" in items:
                    cell = " P "
                elif "gold" in items:
                    cell = " G "
                elif "bat" in items:
                    cell = " B "
                else:
                    cell = "   "

            # 3) Visitada
            elif coord in visited:
                cell = " . "

            # 4) Desconhecida
            else:
                cell = " ? "

            row += cell
        output += row + "\n"
    return output


def main():
    debug = input("Enable debug mode? (y/n): ").strip().lower() == "y"
    logger = Logger.setup()
    world = World(size=6, debug=debug)
    agent = Agent(world)
    visited = set()

    print("=== Wumpus World — Intelligent Agent ===")

    percepts = world.get_percepts(agent)
    turn = 0

    try:
        while True:
            print(draw_world(world, agent, visited), end="")
            print(f"Score: {agent.score}   Arrows: {agent.arrows}   Gold: {agent.gold}")

            cmd = agent.next_action(percepts)
            print(f">>> Agent executes: {cmd}")

            turn += 1
            logger.info(f"--- Turn {turn} ---")
            logger.info(draw_world(world, agent, visited).rstrip())
            logger.info(f"Action: {cmd} | Pos before: ({agent.x},{agent.y})")

            percepts, event, reward = world.perform_action(agent, cmd)
            agent.score += reward
            if cmd == "pick":
                agent.gold += 1

            logger.info(f"Percepts: {percepts}")
            logger.info(f"Event: {event} | Reward: {reward} | Score: {agent.score}")

            # Eventos terminais
            if event in ("pit", "wumpus"):
                print(f">>> Agent died by {event}.")
                break
            if event == "exit":
                print(">>> Agent returned safely!")
                break

    except KeyboardInterrupt:
        print("\n>>> Interrupted by user.")
    except Exception as e:
        print(f"\n>>> Unexpected error: {e}")
    finally:
        print(f"Final Score: {agent.score}")
        print("Log: wumpus.log")


if __name__ == "__main__":
    main()

from utils.environment import World
from utils.agent import Agent
from utils.logger import Logger

VALID_ACTIONS = {"w", "a", "s", "d", "pick", "shoot", "climb"}


def draw_world(world: World, agent: Agent, visited: set) -> str:
    output = ""
    for y in range(world.size - 1, -1, -1):
        row = ""
        for x in range(0, world.size):
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
    debug_mode = input("Enable debug mode? (y/n): ").strip().lower() == "y"
    logger = Logger.setup()
    world = World(size=6, debug=debug_mode)
    agent = Agent()
    visited = set()

    print("=== Wumpus World ===")
    print("Commands: w/a/s/d | pick | shoot | climb")

    percepts = world.get_percepts(agent)
    turn = 0

    try:
        while True:
            print(draw_world(world, agent, visited), end="")
            active = [p for p, v in percepts.items() if v]
            print("Percepts:", ", ".join(active) if active else "none")
            print(f"Score: {agent.score}   Arrows: {agent.arrows}   Gold: {agent.gold}")

            cmd = input("Action: ").strip().lower()
            if cmd not in VALID_ACTIONS:
                print("Invalid command.")
                continue

            turn += 1
            logger.info(f"--- Turn {turn} ---")
            logger.info(draw_world(world, agent, visited).rstrip())
            logger.info(f"Action: {cmd} | Pos: ({agent.x},{agent.y})")

            percepts, event, reward = world.perform_action(agent, cmd)
            agent.score += reward

            logger.info(f"Percepts: {percepts}")
            logger.info(f"Event: {event} | Reward: {reward} | Score: {agent.score}")

            # Eventos terminais
            if event == "pit":
                print(">>> You fell into a pit! GAME OVER.")
                break
            if event == "wumpus":
                print(">>> The Wumpus ate you! GAME OVER.")
                break
            if event == "exit":
                print(">>> You escaped the cave safely!")
                break

            # Eventos intermediários
            if event == "gold":
                print(">>> You picked up gold!")
            elif event and event.startswith("wumpus_killed_"):
                n = int(event.split("_")[-1])
                s = "Wumpus" if n == 1 else "Wumpuses"
                print(f">>> You killed {n} {s}!")
            elif event == "no_arrows":
                print(">>> No arrows left!")
            elif event == "bat":
                print(">>> A bat carried you!")

            logger.info("-" * 40)

    except KeyboardInterrupt:
        print("\n>>> Interrupted by user.")
    except Exception as e:
        print(f"\n>>> Unexpected error: {e}")
    finally:
        print(f"Final Score: {agent.score}")
        print("Game log saved to wumpus.log")


if __name__ == "__main__":
    main()

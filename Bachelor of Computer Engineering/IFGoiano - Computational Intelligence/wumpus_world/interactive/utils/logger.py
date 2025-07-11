import logging


class Logger:
    @staticmethod
    def setup(file_name: str = "wumpus.log") -> logging.Logger:
        logger = logging.getLogger("wumpus")
        logger.setLevel(logging.INFO)

        handler = logging.FileHandler(file_name, mode="w", encoding="utf-8")
        handler.setFormatter(logging.Formatter("%(message)s"))

        if logger.hasHandlers():
            logger.handlers.clear()
        logger.addHandler(handler)
        return logger

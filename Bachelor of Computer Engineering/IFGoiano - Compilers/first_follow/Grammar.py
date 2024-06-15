class Grammar:
    def __init__(self, file_name=None):
        # Initialize an empty dictionary to store the grammar
        self.grammar = {}

        # If a file name is passed as a parameter
        if file_name:
            lines = []

            # Open the specified file and read its lines
            with open(file_name, "r") as file:
                while True:
                    line = file.readline()

                    if not line:
                        break

                    else:
                        line = line.replace("\n", "")
                        lines.append(line)
            
            # Iterate through each line of the file
            for line in lines:
                # Split the line into head and production
                head, production = line.replace(" ", "").split("=")

                # If the head is not already in the grammar
                if head not in self.grammar:
                    self.grammar.update({head: [production]})  # Add the head and production as a list
                
                else:
                    self.grammar[head].append(production)  # Just add the production to the existing list


    # Not used, since the exercise provided the grammar
    def add_production(self, head, productions):
        # Add a new production to the specified head
        self.grammar.update({head: productions})


    # Function to compute the first set of the grammar
    def first(self):
        # Internal function to compute the first sets of a non-terminal
        def _calc_first(head):
            first = set()

            # Iterate through each production of the non-terminal
            for prod in self.grammar[head]:
                # Check the first symbol of the production
                if prod[0].islower():  # If it's a terminal
                    first.add(prod[0])

                elif prod == "#":  # If it's an empty symbol
                    first.add(prod)

                else:  # If it's a non-terminal
                    first_of_prod = _calc_first(prod[0])

                    first.update(first_of_prod)

            return first
        
        # Initialize an empty dictionary to store the first sets of the grammar
        first_values = {}

        # Iterate through each head in the grammar
        for head in self.grammar.keys():
            # Compute the first sets for the current head
            first = _calc_first(head)

            # Add the first sets to the dictionary
            first_values[head] = first
                
        return first_values
    

    # Function to compute the follow set of the grammar
    def follow(self):
        # Internal function to compute the follow sets of a non-terminal
        def _calc_follow(head, visited=None):
            if visited is None:
                visited = set()

            # If the head has already been visited
            if head in visited:
                return set()  # Return an empty set to avoid infinite recursion

            visited.add(head)

            follow = set()

            if head == "S":
                follow.add("$")
            
            # Iterate through all non-terminals in the grammar
            for non_terminal, productions in self.grammar.items():
                # Iterate through all productions of the current non-terminal
                for production in productions:
                    # Iterate through all symbols in the production
                    for i, symbol in enumerate(production):
                        if symbol == head:
                            # If it's not the last symbol in the production
                            if i < len(production) - 1:
                                next_symbol = production[i + 1]  # Get the next element

                                # Check the obtained symbol
                                if next_symbol.islower():  # If it's a terminal
                                    follow.add(next_symbol)
                                
                                elif next_symbol in self.grammar.keys():  # If it's a non-terminal
                                    follow.update(firsts[next_symbol])
                                    
                                    # If the empty symbol is in the first of the obtained symbol
                                    if "#" in firsts[next_symbol]:
                                        follow_of_non_terminal = _calc_follow(non_terminal, visited)
                                        
                                        follow.update(follow_of_non_terminal)
                            
                            # If it's the last symbol in the production
                            else:
                                follow_of_non_terminal = _calc_follow(non_terminal, visited)
                                
                                follow.update(follow_of_non_terminal)
        
            return follow

        # Initialize an empty dictionary to store the follow sets of the grammar
        follow_values = {}

        firsts = self.first()

        # Iterate through each head in the grammar
        for head in self.grammar.keys():
            # Compute the follow sets for the current head
            follow = _calc_follow(head)
            follow.discard("#")  # Discard any "#" elements

            # Add the follow sets to the dictionary
            follow_values[head] = follow

        return follow_values
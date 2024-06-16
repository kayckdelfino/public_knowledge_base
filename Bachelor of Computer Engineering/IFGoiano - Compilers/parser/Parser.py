class Parser:
    def __init__(self, grammar, shift_reduce_table):
        self.grammar = grammar
        self.shift_reduce_table = shift_reduce_table
    
    # Perform the shift operation
    def _shift(self, action_state, input_str, state_stack, symbol_stack):
        symbol_stack.append(input_str[0])
        state_stack.append(int(action_state))
        return input_str[1:]
    
    # Perform the reduce operation
    def _reduce(self, reduce_prod, state_stack, symbol_stack):
        # Get the production to be reduced
        head, production = list(self.grammar[reduce_prod].items())[0]

        prod_size = len(production)

        # Check if the symbols on top of the stack match the production
        if symbol_stack[-prod_size:] == list(production):
            del symbol_stack[-prod_size:]
            del state_stack[-prod_size:]
            symbol_stack.append(head)

            # Determine the new state from the shift-reduce table
            new_state = self.shift_reduce_table.get(state_stack[-1]).get(head)

            if new_state is None:
                raise Exception("No new state after reduce")

            state_stack.append(new_state)
        else:
            raise Exception("Invalid reduction")

        return state_stack, symbol_stack

    def test(self, input_str, verbose=False):
        # Append the end of input symbol "$" if not present
        if input_str[-1] != "$":
            input_str = input_str + "$"

        state_stack = [0]
        symbol_stack = []

        while True:
            current_state = state_stack[-1]
            current_char = input_str[0]

            # Get the action to take from the shift-reduce table
            action = self.shift_reduce_table.get(current_state).get(current_char)

            if verbose:
                print(f"action = {action}")
                print(f"input = {input_str}")
                print(f"symbols = {symbol_stack}")
                print(f"states = {state_stack}")
                print("===============================")

            if not action:
                raise Exception("No action identified in the table")

            if len(action) not in [2, 3]:
                raise Exception("Invalid element found in table")

            # Shift action
            if action[0] == "s":
                input_str = self._shift(action[1], input_str, state_stack, symbol_stack)

            # Reduce action
            elif action[0] == "r":
                state_stack, symbol_stack = self._reduce(int(action[1]), state_stack, symbol_stack)

            # Accept action
            elif action == "acc" and symbol_stack == ["S"] and input_str == "$":
                return True  # Valid input

def main():
    transition_table_nfa = {
        "q0": {"0": {"q0", "q1"}, "1": {"q0"}},
        "q1": {"0": {""}, "1": {"q2"}},
        "q2": {"0": {""}, "1": {""}},
    }

    initial_state_nfa = "q0"
    acceptance_states_nfa = {"q2"}

    epsilon_transitions = {}
    for state, transitions in transition_table_nfa.items():
        epsilon_transitions[state] = transitions.get("", set())

    # Print the NFA transition table
    print("NFA Transition Table:")
    # Column headers
    print(f"{'':<8}", end="")
    for symbol in transition_table_nfa["q0"].keys():
        print(f"{symbol:<15}", end="")
    print("")

    # Rows of the transition table
    for state, transitions in transition_table_nfa.items():
        print(f"{state:<8}", end="")
        for symbol, next_states in transitions.items():
            print(f"{', '.join(next_states):<15}", end="")
        print("")

    dfa_transition_table, dfa_states, alphabet = nfa_to_dfa(transition_table_nfa, initial_state_nfa, acceptance_states_nfa)
    sorted_dfa_states = sorted(list(dfa_states))

    # Create a mapping of states to uppercase letters
    state_to_letter = {state: chr(ord('A') + i) for i, state in enumerate(sorted_dfa_states)}

    # Print the DFA transition table formatted with renamed states
    print("\nDFA Transition Table:")
    # Column headers
    print(f"{'':<8}", end="")
    sorted_alphabet = sorted(alphabet)
    for symbol in sorted_alphabet:
        print(f"{symbol:<15}", end="")
    print("")

    # Rows of the transition table
    for state in sorted_dfa_states:
        renamed_state = state_to_letter[state]
        print(f"{renamed_state:<8}", end="")
        for symbol in sorted_alphabet:
            next_state = dfa_transition_table.get(state, {}).get(symbol, "-")
            next_state_renamed = state_to_letter.get(next_state, "-")
            print(f"{next_state_renamed:<15}", end="")
        print("")

    # Find the initial state of the DFA and acceptance states
    initial_state_dfa = None
    acceptance_states_dfa = set()
    for state, transitions in dfa_transition_table.items():
        if "acceptance" in transitions:
            acceptance_states_dfa.add(state)
        if state == name_state(epsilon_closure({initial_state_nfa}, epsilon_transitions)):
            initial_state_dfa = state

    # Print the initial state and acceptance states of the DFA
    print("\nInitial State of the DFA:", state_to_letter[initial_state_dfa])
    print("Acceptance States of the DFA:", ", ".join(state_to_letter[state] for state in acceptance_states_dfa))


# Calculate the epsilon closure of a set of states.
def epsilon_closure(states, epsilon_transitions):
    epsilon_states = set(states)
    stack = list(states)
    while stack:
        state = stack.pop()
        epsilon_transitions_state = epsilon_transitions.get(state, set())
        epsilon_states.update(epsilon_transitions_state - epsilon_states)
        stack.extend(epsilon_transitions_state - epsilon_states)
    return epsilon_states


# Calculate the states reachable from a set of states with an input symbol.
def transition(states, symbol, nfa_transition_table):
    next_states = set()
    for state in states:
        next_states.update(nfa_transition_table.get(state, {}).get(symbol, set()))
    return next_states


# Generate a unique name for a set of states.
def name_state(states):
    return "".join(sorted(states))


# Convert an NFA to a DFA.
def nfa_to_dfa(transition_table, initial_state_nfa, acceptance_states_nfa):
    epsilon_transitions = {}
    for state, transitions in transition_table.items():
        epsilon_transitions[state] = transitions.get("", set())

    alphabet = set(symbol for transitions in transition_table.values() for symbol in transitions if symbol != "")

    dfa_states = set()
    dfa_transition_table = {}
    stack = [epsilon_closure({initial_state_nfa}, epsilon_transitions)]
    dfa_states.add(name_state(stack[0]))

    while stack:
        current_states = stack.pop()
        acceptance_state_present = any(state in acceptance_states_nfa for state in current_states)
        if acceptance_state_present:
            dfa_transition_table[name_state(current_states)] = {"acceptance": True}
        for symbol in alphabet:
            next_states = epsilon_closure(transition(current_states, symbol, transition_table), epsilon_transitions)
            if not next_states:
                continue
            name_next_state = name_state(next_states)
            if name_next_state not in dfa_states:
                dfa_states.add(name_next_state)
                stack.append(next_states)
            if name_state(current_states) not in dfa_transition_table:
                dfa_transition_table[name_state(current_states)] = {}
            dfa_transition_table[name_state(current_states)][symbol] = name_next_state

    return dfa_transition_table, dfa_states, alphabet


if __name__ == "__main__":
    main()
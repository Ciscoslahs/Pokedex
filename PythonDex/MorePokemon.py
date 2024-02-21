from ChooseDex import choose_dex


def more_pokemon():
    """This function asks the user if they would like to see more Pokémon."""
    print("Would you like to see more Pokémon? (Yes or y to continue, anything else to exit)" + "\n")
    more_mons = input()

    if more_mons.lower() == "yes" or more_mons.lower() == "y":
        choose_dex()
        more_pokemon()
    else:
        print("Goodbye!")

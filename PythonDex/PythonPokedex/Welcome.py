from MorePokemon import more_pokemon
from ChooseDex import choose_dex


def welcome():
    """This function welcomes the user to the Pokémon database."""
    print("Welcome to the Pokémon database!" + "\n")
    choose_dex()
    more_pokemon()


welcome()
import random


def random_mon():
    """This function chooses a random Pokémon from the Pokédex."""
    with open('Pokemon.txt', 'r') as Pokédex:
        mons = Pokédex.readlines()
        rand_mon = random.choice(mons)
        print(rand_mon)

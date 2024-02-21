from SurprisedPikachuImage import surprised_pikachu


def get_mons():
    """This function asks the user which Pokémon they are looking for and then searches the Pokédex for it."""
    wanted_mon = input("What Pokémon are you looking for? " + "\n")
    found_mon = False

    with open('Pokemon.txt', 'r') as Pokédex:
        for pokédex_entry in Pokédex:
            if wanted_mon.lower() in pokédex_entry.lower():
                print("\n" + pokédex_entry)
                found_mon = True

    if not found_mon:
        print("There is no Pokémon with that name.")
        surprised_pikachu()

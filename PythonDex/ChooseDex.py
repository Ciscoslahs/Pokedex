from GetMons import get_mons
from RandomMon import random_mon
from SurprisedPikachuImage import surprised_pikachu


def choose_dex():
    """This function allows the user to choose which dex they want to use. It then calls the appropriate function."""
    print("Choose a dex"
          "\n1. Regular"
          "\n2. Stats"
          "\n3. Random"
          "\n(Pick a number)" + "\n")
    dex = input()
    dex_chosen = False
    if dex == "1":
        get_mons()
        dex_chosen = True
    if dex == "2":
        get_mons()
        dex_chosen = True
    if dex == "3":
        random_mon()
        dex_chosen = True
    if not dex_chosen:
        print("That is not a valid choice.")
        surprised_pikachu()

#!/usr/bin/env python

"""entertainment_center.py: This script create a list of 6 Movie objects and
passes them to fresh_tomatoes.open_movies_page() where they will be used to
generate a web page."""

__author__ = "Joyce Echessa"

import fresh_tomatoes
import media

fight_club = media.Movie(
    "Fight Club",
    "https://upload.wikimedia.org/wikipedia/en/f/fc/Fight_Club_poster.jpg",
    "https://www.youtube.com/watch?v=SUXWAEX2jlg")
frozen = media.Movie(
    "Frozen",
    "https://upload.wikimedia.org/wikipedia/en/0/05/Frozen_%282013_film%29_poster.jpg",  # noqa
    "https://www.youtube.com/watch?v=TbQm5doF_Uc")
her = media.Movie(
    "Her",
    "https://upload.wikimedia.org/wikipedia/en/4/44/Her2013Poster.jpg",
    "https://www.youtube.com/watch?v=WzV6mXIOVl4")
matrix = media.Movie(
    "The Matrix",
    "https://upload.wikimedia.org/wikipedia/en/c/c1/The_Matrix_Poster.jpg",
    "https://www.youtube.com/watch?v=m8e-FF8MsqU")
civil_war = media.Movie(
    "Captain America: Civil War",
    "https://upload.wikimedia.org/wikipedia/en/5/53/Captain_America_Civil_War_poster.jpg",  # noqa
    "https://www.youtube.com/watch?v=dKrVegVI0Us")
deadpool = media.Movie(
    "Deadpool",
    "https://upload.wikimedia.org/wikipedia/en/4/46/Deadpool_poster.jpg",
    "https://www.youtube.com/watch?v=9vN6DHB6bJc")
movies = [fight_club, frozen, her, matrix, civil_war, deadpool]

# Pass the list of Movie objects to fresh_tomatoes.open_movies_page() which
# will use their data to generate a static web page
fresh_tomatoes.open_movies_page(movies)

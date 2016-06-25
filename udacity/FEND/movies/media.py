import webbrowser

class Movie():
    """This class stores movie related information.

    Attributes:
        title: A String for the title of the movie
        poster_image_url: A String for the URL of the movie's box art image
        trailer_youtube_url: A String for the URL of the movie's trailer on YouTube  # noqa
    """

    def __init__(self, movie_title, poster_image, trailer_youtube):
        self.title = movie_title
        self.poster_image_url = poster_image
        self.trailer_youtube_url = trailer_youtube

package com.hai.exercise.nytmovereview.model

import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.google.gson.Gson


data class Review(
        val status: String,
        val copyright: String,
        val num_results: Int,
        val results: List<Result>
){
    //Review Deserializer
    class Deserializer : ResponseDeserializable<Review> {
        override fun deserialize(content: String) = Gson().fromJson(content, Review::class.java)
    }
}

data class Result(
        val display_title: String,
        val mpaa_rating: String,
        val critics_pick: Int,
        val byline: String,
        val headline: String,
        val summary_short: String,
        val publication_date: String,
        val opening_date: String,
        val date_updated: String,
        val link: Link,
        val multimedia: Multimedia
)

data class Link(
        val type: String,
        val url: String,
        val suggested_link_text: String
)

data class Multimedia(
        val type: String,
        val src: String,
        val height: Int,
        val width: Int
)

/*
{
  "status": "OK",
  "copyright": "Copyright (c) 2018 The New York Times Company. All Rights Reserved.",
  "has_more": false,
  "num_results": 7,
  "results": [
    {
      "display_title": "ABCD 2 (Anybody Can Dance 2)",
      "mpaa_rating": "",
      "critics_pick": 0,
      "byline": "ANDY WEBSTER",
      "headline": "Review: &#8216;ABCD 2,&#8217; TV Dance Stars Try to Rebuild Their Team and Reputation",
      "summary_short": "The leader of the Mumbai Stunners troupe hopes to turn around the group&#8217;s fortunes in this Remo D&#8217;Souza Bollywood sequel.",
      "publication_date": "2015-06-18",
      "opening_date": "2015-06-19",
      "date_updated": "2017-11-02 04:18:21",
      "link": {
        "type": "article",
        "url": "http://www.nytimes.com/2015/06/19/movies/review-abcd-2-tv-dance-stars-try-to-rebuild-their-team-and-reputation.html",
        "suggested_link_text": "Read the New York Times Review of ABCD 2 (Anybody Can Dance 2)"
      },
      "multimedia": {
        "type": "mediumThreeByTwo210",
        "src": "https://static01.nyt.com/images/2015/06/19/arts/19ABCD/19ABCD-mediumThreeByTwo210.jpg",
        "width": 210,
        "height": 140
      }
    },
    {
      "display_title": "The ABCs of Death",
      "mpaa_rating": "Not Rated",
      "critics_pick": 0,
      "byline": "JEANNETTE CATSOULIS",
      "headline": "26 Ways to Die Gruesomely",
      "summary_short": "Everybody’s got to go sometime in “The A B Cs of Death,” a collection of horror shorts in many languages.",
      "publication_date": "2013-03-07",
      "opening_date": null,
      "date_updated": "2017-11-02 04:16:36",
      "link": {
        "type": "article",
        "url": "http://www.nytimes.com/2013/03/08/movies/the-a-b-cs-of-death-26-gory-vignettes.html",
        "suggested_link_text": "Read the New York Times Review of The ABCs of Death"
      },
      "multimedia": null
    },
    {
      "display_title": "Scenes of a Crime",
      "mpaa_rating": "",
      "critics_pick": 0,
      "byline": "STEPHEN HOLDEN",
      "headline": "A Death, a Conviction, and a Disputed Confession",
      "summary_short": "“Scenes of a Crime,” a documentary, explores modern police interrogation methods, specifically the Reid Technique, whose goal is to extract a confession using sophisticated psychological manipulation.",
      "publication_date": "2012-03-29",
      "opening_date": "2012-03-30",
      "date_updated": "2017-11-02 04:18:15",
      "link": {
        "type": "article",
        "url": "http://www.nytimes.com/2012/03/30/movies/scenes-of-a-crime-from-blue-hadaegh-and-grover-babcock.html",
        "suggested_link_text": "Read the New York Times Review of Scenes of a Crime"
      },
      "multimedia": null
    },
    {
      "display_title": "ABC Africa",
      "mpaa_rating": "Not Rated",
      "critics_pick": 0,
      "byline": "A. O. Scott",
      "headline": "Abc Africa (Movie)  ",
      "summary_short": "Abbas Kiarostami's documentary is about Ugandan children orphaned by the successive disasters of civil war and AIDS. There is some aggression in Mr. Kiarostami's method, but also great delicacy and tact. The richness and emotional impact of this film comes partly from the balance it achieves between the director's personality and his vast, terrible subject. He never pretends to have mastered the subject &#151; the film's title suggests the elementary state of his knowledge &#151; or to be able to solve Uganda's problems by observing them. But you come away from his film overwhelmed, hopeful and, perhaps paradoxically, illuminated. &#151; A. O. Scott \r\n",
      "publication_date": "2002-05-03",
      "opening_date": null,
      "date_updated": "2017-11-02 04:16:20",
      "link": {
        "type": "article",
        "url": "http://www.nytimes.com/movie/review?res=9902E4DA1331F930A35756C0A9649C8B63",
        "suggested_link_text": "Read the New York Times Review of ABC Africa"
      },
      "multimedia": null
    },
    {
      "display_title": "ABCD",
      "mpaa_rating": "Not Rated",
      "critics_pick": 0,
      "byline": "Stephen Holden",
      "headline": "ABCD (Movie)",
      "summary_short": "Krutin Patel's film &quot;ABCD&quot; (the initials stand for American-born confused desi) explores the internal tug of war affecting upwardly mobile young Indian-Americans brought up in this country. Desi is a word for someone of Indian extraction living outside India, and &quot;ABCD&quot; a slang term of amused disparagement applied to those who deny (and sometimes attempt to cover up) their backgrounds. The central characters, Nina (Sheetal Sheth) and her older brother Raj (Faran Tahir), are both successful young professionals (she works in advertising, he in accounting) and both struggling with similarly conflicting impulses. &quot;ABCD&quot; doesn't make light of its characters' conflicts, nor does it try to resolve them with feel-good formulaic solutions. – Stephen Holden",
      "publication_date": "2001-11-30",
      "opening_date": null,
      "date_updated": "2017-11-02 04:16:18",
      "link": {
        "type": "article",
        "url": "http://www.nytimes.com/movie/review?res=9F0CE7DC123DF933A05752C1A9679C8B63",
        "suggested_link_text": "Read the New York Times Review of ABCD"
      },
      "multimedia": null
    },
    {
      "display_title": "The Alphabet Murders",
      "mpaa_rating": "",
      "critics_pick": 0,
      "byline": "A.H. WEILER",
      "headline": "Alphabet Murders, The (Movie)",
      "summary_short": "Sloppy handling of Christie whodunit. Tony's a terrible Poirot.",
      "publication_date": "1966-07-12",
      "opening_date": "1966-05-17",
      "date_updated": "2017-11-02 04:17:22",
      "link": {
        "type": "article",
        "url": "http://www.nytimes.com/movie/review?res=9D01E0D91E3DE43BBC4A52DFB166838D679EDE",
        "suggested_link_text": "Read the New York Times Review of The Alphabet Murders"
      },
      "multimedia": null
    },
    {
      "display_title": "Manewry Milosne",
      "mpaa_rating": "",
      "critics_pick": 0,
      "byline": "H.T.S.",
      "headline": "Manewry Milosne",
      "summary_short": "",
      "publication_date": "1936-11-11",
      "opening_date": "1936-11-10",
      "date_updated": "2017-11-02 04:16:59",
      "link": {
        "type": "article",
        "url": "http://www.nytimes.com/movie/review?res=9803EEDC1E39EE3BBC4952DFB767838D629EDE",
        "suggested_link_text": "Read the New York Times Review of Manewry Milosne"
      },
      "multimedia": null
    }
  ]
}

 */
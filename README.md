# Pinyu
This app currently functions like a pocket dictionary. It contains a little over 50 Chinese words spanning different categories.

Pinyu is my first attempt to try and utilize less-naive design practices. I attempt to follow the MVP pattern here
for my vocab review screens. I'm also utilizing inheritence and some static
variables and methods to help with organization and navigation.

<p align="center">
<img src="https://github.com/ashfordhill/LearnChinese/blob/master/screenshots/mainmen.png" width="275">
<img src="https://github.com/ashfordhill/LearnChinese/blob/master/screenshots/categoryscreen.png" width="275">
<img src="https://github.com/ashfordhill/LearnChinese/blob/master/screenshots/animalsscreen.png" width="275">
</p>

# How it works
Pinyu gets its words from an SQLite database that contains the english word, pinyin, chinese character, category of a word,
as well as corresponding sound and image resource IDs. The database can be found in assets/words.db.

The Content Provider (WordProvider.java) is defined in AndroidManifest.xml file. This Provider is accessed by
the Content Loader in the Vocab Activity parent class. The Loader uses a URI to access the Provider and query
different categories to display for each activity, depending on which category the user selected. This data is loaded into a custom adapter that defines the display formatting for the words and the sound play buttons.

# Possible improvements
Improvements to this app would include using Fragments over Activities for the vocabulary review screens, as well as potentially using a Navigation Architecture Component to handle different fragment navigations. 

# Acknowledgements
A big thanks to Yu Qi for recording the sound clips in Mandarin, as well as 
<a href="https://www.flaticon.com/authors/roundicons">Roundicons</a> and <a href="https://www.flaticon.com/authors/Freepik">Freepik</a>
from www.flaticons.com for all of the icons.

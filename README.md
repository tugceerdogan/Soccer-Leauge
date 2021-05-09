# Soccer-Leauge


-This project is a soccer leauge mobile application project. It is written using Google's suggested Kotlin language and OOP principles.

-The application uses MVVM architecture.

-Using the RETROFIT and RXJAVA libraries, the application can download the team names and the images of the teams in the REST API I created and 
show them to the user via recyclerview. 

-At the same time, it saves the data downloaded from the internet through Room DB and ensures that the teams are listed even in case of an internet connection loss.

-The screen where the teams are listed is dynamic, it was created with an algorithm to list any number of teams to be added to the Json file.

-A splash screen has also been added to the application. This plugin makes the application user friendly. 

-This application supports night mode. 

-The draw fixture button on the home page takes you to the screen showing the matches of each week. 

-By sliding the screen from right to left as desired, the matches of the next week are shown, 
and by sliding from left to right, the matches of the past week are shown together with the scores. 

-These screens are unfortunately not dynamic. Due to the shortage of time, the matches were added manually in order to complete the application completely.

-As requested, animations have been added when passing from team list screen to first-week match fixture.

-And finally, the apk file of the application was created and it is in the releases.

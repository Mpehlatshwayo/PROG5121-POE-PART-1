PROG POE PART ONE
During the development of the login and registration system for the development of the chat app I received consistent help from Microsoft Copilot, a generative AI tool. Copilot helped me understand and implement the required programming concepts like  GUI design using Java swing, password validation logic and Junit testing. Its step-by-step guidance has helped me develop a code in a beginner friendly way that is up to par with my coding skills level.
 Copilot has helped with debugging test failures and explain what I did wrong within my code, and it has given me solutions on how to correct my code so it can meet academic standards. It provided clear explanations for regular expressions, validation rules and design layout which improved both the functionality of my code and the readability.
Beyond the technical help Copilot offered me emotional encouragement with suggestions on the type of design I would like for the app. This put me more at ease and made me less overwhelmed. I not only consider Copilot as an assistant but as a companion on my academic journey.


PROG POE PART TWO
During part two of the POE, I made use of string manipulations and creating and working with loops to add more functionality to the messenger app being designed called Quickchat. During this part the aim was to ensure that user input like password, recipients cell number, and message are stored in a Json file and validated properly. We also used Junit testing to confirm the information on the java project.


Methods added
We used several methods to add more functionality to the application. For example, the isValidPassword method ensure that then password entered by the user meet the requirements otherwise the user cannot proceed to the next part of the app. The checkRecipientCell ensures that the user’s phone number contains the south African (+27) international code. Then we have isValidMessage  method it checks whether the message isn’t empty and also if it is below 250 characters, we the have genrerateMessageID and  createMessageHash the first one help to generate a message id to track the messages using a 10 digit numeric string the we have creating a message hash lastly we have the readStoredMessage method this method helps store messages sent in a JSON file so they can be captured and viewed.
 Below is a sample code of my testRecipientCell number test code.
 
JUNIT TESTING
In order for us to verify whether the methods are correct we used unit tests to highlight my understanding I used comments to remind me of what each test does. The password validation test confirms password that met the requirements to be accepted. Message validation demonstrates that message that where to long  or empty cannot be accepted. Test for recipients’ cell number ensue that only numbers containing (+27)) south African international code are accepted by the system. The message ID generation help to confirm that the ID are where numeric and contain 10 digits, additional test helped us store messages so we can access them when we click the stored messages  button in the program, the main program run with no errors these test provide us with evidence of a code with no errors that runs smoothly.
 
Above is evidence that all my tests run successfully my file has no errors.

Conclusion 
In conclusion , during this part of the POE it highlighted the importance of  validation  and the role of JUnit testing  and the use of Json file in storing memory. All these parts come together to help form the messenger application called QUICKCHAT.


Bibliography
@alexlorenlee, 2020. Java GUI Tutorial - Make a GUI in 13 Minutes #99. [Online] 
Available at: https://www.youtube.com/watch?v=5o3fMLPY7qY
[Accessed 7 October 2025].
@BillBarnum, 2019. Random Numbers With Math.random() (Java Tutorial). [Online] 
Available at: https://www.youtube.com/watch?v=Q9LIxVENfLU
[Accessed 4 October 2025].
@BroCodez, 2024. METHODS in Java are easy 📞. [Online] 
Available at: https://www.youtube.com/watch?v=JKecvKiNX2I
[Accessed 2 October 2025].
@smartherd, 2017. Java STRINGS tutorial with example. Java Tutorial for Beginners #7.2. [Online] 
Available at: https://www.youtube.com/watch?v=Ota1s_4kTyU
[Accessed 4 October 2025].
Anon., 2020. Hello World | Java Swing Tutorial for Beginners. [Online] 
Available at: https://www.youtube.com/watch?v=1vVJPzVzaK8&list=PL3bGLnkkGnuV699lP_f9DvxyK5lMFpq6U
[Accessed 7 October 2025].
Anon., 2020. Java GUI Tutorial - Make a GUI in 13 Minutes #99. [Online] 
Available at: https://www.youtube.com/watch?v=5o3fMLPY7qY
[Accessed 1 October 2025].
Anon., n.d.. How to Create a Unique Message ID in Java. [Online] 
Available at: https://codingtechroom.com/question/-create-message-id-java
[Accessed 1 October 2025].
Baeldung, 2023. A Guide to JUnit 5. [Online] 
Available at: https://www.baeldung.com/junit-5
[Accessed 11 september 2025].
geeksforgeeks., 2025. Java Swing | Simple User Registration Form. [Online] 
Available at: https://www.geeksforgeeks.org/java/java-swing-simple-user-registration-form/
[Accessed 2 October 2025].
Microsoft, 2025. Copilot – Generative AI assistance for coding and academic support. [Online] 
Available at: https://copilot.microsoft.com/
[Accessed 10 September 2025].
mkyong, 2024. Read and write JSON using JSON.simple. [Online] 
Available at: https://mkyong.com/java/json-simple-example-read-and-write-json/
[Accessed 2 October 2025].
Oracle, n.d. JDK 25 Documentation. [Online] 
Available at: https://docs.oracle.com/en/java/javase/25/
[Accessed 11 september 2025].
Stefan Bechtold, S. B. L. M. P. d. R. S., n.d.. JUnit User Guide. [Online] 
Available at: https://docs.junit.org/current/user-guide/
[Accessed 11 October 2025].





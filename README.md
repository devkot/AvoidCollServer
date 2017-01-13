Prodject_Devs Team
Κοτανίδης Στέλιος 1115201300236
Φακίνος Ιάκωβος 1115201300191
Απλαδάς Αγαμέμνων 1115201300013
Θόδη Δήμητρα 1115201300052

Η Εφαρμογή του Υπολογιστή έχει υλοποιηθεί ώστε να ακούει μέσω MQTT Broker στο υποδίκτυό του τερματικά Android και να πέρνει αποφάσεις για επιβεβαιομένες η μή συγκρούσεις.
Τα Topics είναι χωρισμένα ανα κατηγορία αισθητήρα ως εξής:
1. Για τον Subscriber της εφαρμογής εχουμε τα “+/Light” , “+/Proximity”, “+/Acceleration” όπου αποστέλοντε τα μυνήματα απο τα τερματικά.Το πρώτο πεδίο αφορά το μοναδίκο ID του κάθε κινητού τερματικού.
2. Όταν αποφανθεί ο σέρβερ οτι υπάρχει σύγκρουση ενός μόνο τερματικόυ τότε κάνει Publish στα αντίστοιχα topics “Light/Danger”, “Proximity/Danger” kai “Acceleration/Danger”
3. Αντίστοιχα για επιβεβαιομένη σύγκρουση μεταξύ δύο τερματικών γίνεται Publish στα Topics “Light/Confirmed” “Proximity/Confirmed” “Acceleration/Confirmed” στα οποία κάνουν Subscribe οι εφαρμογές στα αντίστοιχα τερματικά.
Οι Μέθοδοι που υλοποιούντε για αυτές τις λειτουργείες είναι οι εξής:
Subscriber
1. main
2. connectionLost
3. messageArrived
4. deliveryComplete
Publisher
SubCaller
PubCaller
1. PubCaller
2. run
DoTheJob
1. public DoTheJob
DoTheJobCaller
1. DoTheJobCaller
2. run
SampleMain
1. public static void main
MainServerClass
1. public static void main

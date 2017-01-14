Project_Devs Team
Κοτανίδης Στέλιος 1115201300236
Φακίνος Ιάκωβος 1115201300191
Απλαδάς Αγαμέμνων 1115201300013
Θόδη Δήμητρα 1115201300052


Η Εφαρμογή Java του server έχει υλοποιηθεί ώστε να ακούει μέσω MQTT Broker στο υποδίκτυό του τερματικά Android και να παιρνει αποφάσεις για επιβεβαιομένεςη μή συγκρούσεις.
Τα Topics είναι χωρισμένα ανα κατηγορία αισθητήρα ως εξής:

1. Για τον Subscriber της εφαρμογής εχουμε τα “+/Light” , “+/Proximity”, “+/Acceleration” όπου αποστέλοντε τα μυνήματα απο τα τερματικά.Το πρώτο πεδίο αφορά το μοναδίκο ID του κάθε κινητού τερματικού.

2. Όταν αποφανθεί ο σέρβερ οτι υπάρχει σύγκρουση ενός μόνο τερματικόυ τότε κάνει Publish στα αντίστοιχα topics “Light/Danger/id”, “Proximity/Danger/id” kai “Acceleration/Danger/id” όπου id=το μοναδικό id του κάθε τερματικού.

3. Αντίστοιχα για επιβεβαιομένη σύγκρουση μεταξύ δύο τερματικών γίνεται Publish στα Topics “Light/Confirmed” “Proximity/Confirmed” “Acceleration/Confirmed” στα οποία κάνουν Subscribe οι εφαρμογές στα αντίστοιχα τερματικά.

Οι Κλάσεις που υλοποιούνται για αυτές τις λειτουργείες είναι οι εξής:  
![Image](shot.png)
  >
Subscriber
  >
    1. main  
    2. connectionLost  
    3. messageArrived  
    4. deliveryComplete  
  >  
Publisher
  >
    1.main()->Εδώ δίνονται τα στοιχεία και τα topics στα οποία η εφαρμογή θα αποστείλει ειδοποιήσεις. 
  >
SubCaller  
  >
    1.Υλοποιεί το νήμα όπου τρέχει ο Subscriber.  
  >  
PubCaller
  >
    1.Δημιουργεί το νήμα στο οποίο τρέχει ο Publisher όταν καλείται.  
        1. PubCaller    
        2. run
  >        
DoTheJob 
  >
    1. public DoTheJob 
    Υλοποιείται όλος ο αλγόριθμος για την λήψη απόφασης του σέρβερ,υπολογίζονται τα δεδομένα που λαμβάνονται απο τους αισθητήρες,και καλείται ο Publiser για την κάθε παρίπτωση, καθώς και οι εγγραφές στην βάση δεδομένων μας.  
  >
DoTheJobCaller    
  >
    1.Εδώ υλοποιείται το νήμα στο οποίο τρέχει η συνάρτηση DoTheJob οπου γίνονται όλοι οι υπολογισμοί των δεδομένων.  
        1. DoTheJobCaller  
        2. run  
  >
SampleMain
  >
    1. public static void main  
        Εδώ υλοποιείται η σύνδεση με την βάση,οπου εγγράφονται τα δεδομένα που παραχωρούντε απο την DoTheJob όταν κκριθεί οτι υπάρχει ενδεχόμενη σύγκρουση ή επιβεβαιομένη σύγκρουση.  
MainServerClass  
  >
    Εδώ καλείται η εκκίνηση του προγράμματος στον υπολογιστή.  
      1. public static void main  
  >
  
  
  
  

Android App

Offline Mode:

-Η εφαρμογη ξεκιναει κανονικα οπως υλοποιηθηκε για το πρωτο παραδοτεο. Στην κεντρικη οθονη φαινονται οι μετρησεις απο τους 3 αισθητηρες που χρησιμοποιησαμε (Linear acceleration, Proximity, Light).

-Οταν ξεπερνουνται τα κατωφλια εμφανιζεται heads up notification με ηχο και δονηση και εξαφανιζεται οταν δεν υπαρχει κινδυνος. To notification μπορει να πατηθει οταν ειμαστε στο homescreen και μας πηγαινει πισω στην εφαρμογη μεσω pending intent.

-Η οθονη δεν σβηνει οσο ειμαστε στην κεντρικη οθονη της εφαρμογης.

-Μπορουμε να κανουμε exit μεσω του back button μεσω διαλογου η αμεσως απο το μενου.

-Υπαρχουν 2 διαφορετικα ειδη ρυθμισεων.

-Με το Delay Settings καθοριζουμε την συχνοτητα ανανεωσης των τιμων αλλα και του ελεγχου των αισθητηρων.

-Με το Settings αλλαζουμε το κατωφλι του acceration Και του light μεσω seekbar.

-Γινεται ελεγχος για το αν η συσκευη μας εχει τους συγκεκριμενους αισθητηρες.

-Οι μετρησεις δεν σταματανε οταν κλεισει η οθονη

Online Mode:

-Τροποι μεταβασης σε online mode: Ανοιγμα wifi, απο το μενου επιλεγοντας το online mode η εχοντας ανοιχτο το wifi και μετα ανοιγοντας την εφαρμογη.

-Υπαρχει ενας broadcast receiver που ελεγχει αν ειναι ανοιχτο το wifi μονο και οχι το gps και αν ανοιξει μας πηγαινε στο online mode.

-Αν ειμαστε online και κλεισει το wifi τερματιζει και η εφαρμογη και επιστρεφουμε στο offline.

-Γινεται ελεγχος αν ειναι ανοιχτο το wifi και το gps και εμφανιζεται καταλληλο toast.

-Αν ειναι κλειστο το wifi ανοιγει αυτοματα ενω αν ειναι κλειστο το gps εμφανιζεται διαλογος με τη χρηση του google api.

-Υπαρχει κουμπι στο menu για MQTT settings δηλαδη να αλλαξουμε την IP/port που συνδεεται η συσκευη.

-Υπαρχει switch που ξεκιναει τη μεταδοση των δεδομενων του αισθητηρα.

-Υπαρχει κουμπι στο μενου για να μεταβουμε στο offline mode και κλεινει το wifi.

-Αλλιως μεσω του back button εμφανιζεται διαλογος κλεινει το Wifi και επιστρεφουμε στο Offline.

-Τις μετρησεις τις παιρνουμε μεσω ενος service και μεσα στην Onsensorchanged καλουμε asynctask για να μην υπαρχει συμφορηση. (το πιο κρισιμο σημειο της ασκησης)

-Καθε αισθητηρας υλοποιειται σε ξεχωριστη κλαση.

-Ο subscriber κανει subscribe σε συγκεκριμενα topics Που εχουν οριστει απο μας και συμφωνηθει με τον σερβερ.

-O publisher κανει publish στα topics id/sensor.

-Μεταφερεται επισης η τοποθεσια GPS αν και συνηθως ειναι 0.0 η null αφου ειμαστε πιο συχνα μεσα σε ενα κτηριο.

-Παιρνουμε την τοποθεσια GPS μεσω google api.

Επεξηγηση κλασεων:

-AccelerationService,ProximityService,LightService ειναι τα service που ξεκινανε με intent μεσα απο το switch, κανουν register τους listeners και περνανε τις τιμες του αισθητηρα σε ενα AsyncTask Που θα κανει publish στο background για να μην "Κολλαει" η εφαρμογη.

-SubService ειναι το service που καλει τον subscriber.

-DelaySettings ειναι η κλαση που περιεχει τα spinners για να ελενξουμε την συχνοτητα που παιρνουμε τιμες στους αισθητηρες.

-Init ξεκιναει τον receiver.

-Connectivity receiver ειναι ενας broadcast receiver που ελενχει ΜΟΝΟ αν το Wifi ειναι ανοιχτο/κλειστο και προβαινει μετα σε αντιστοιχες ενεργειες.

***Θεωρησαμε τη συνθηκη της καταστασης GPS εναντια στα δεδομενα του παραδοτεου ως μη χρησιμη καθως το gps δεν μπορει να απενεργοποιηθει οπως το Wifi και οχι τοσο σημαντικο στην λειτουργια της εφαρμογης αρα δεν ελεγχεται αν ειναι ανοιχτο ωστε να μεταβει σε online mode αλλα ΠΑΝΤΑ ζηταει στον χρηστη να το ανοιγει.

-MainActivity περιεχει των κωδικα της κεντρικης οθονης που εξεταστηκε στο πρωτο παραδοτεο και επεκταθηκε για να κανει unregister listeners οταν πηγαινουμε στο Online Mode ωστε να μην πραγματοποιειται τοπικος ελεγχος.

-Publisher απο το eclass με καποιες μικρες αλλαγες κυριως στο content,topics.

-OnMode ειναι η κυρια οθονη του Online κομματιου και περιερχει το μενου για τις online ρυθμισεις η την εξοδο. Ελεγχει αν ειναι ανοιχτο το Wifi/GPS και αν οχι τα ανοιγει. Switch για συνδεση και μεταδοση με MQTT broker. Με backbutton κλεινει και επιστρεφει στο offline.

-Subscriber στο messagearrived εχει μια switch για να ελενξει σε ποιον αισθητηρα ανοικει το μηνυμα που σταλθηκε και μεσω handler επειδη τρεχει στο background καλει toast που δειχνει τον κινδυνο στον χρηστη.

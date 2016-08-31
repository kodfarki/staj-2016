1. producer thread: inserts rows into EVENT table. Yapilmasi gereken isleri EVENT tablosuna kaydediyor.

Her row STDOUT'a (System.out.println) sistem saatini print edilmesi gerektigini ifade eder.


2. worker thread: reads from EVENT table. Yapilmasi gereken isleri yapar.

EVENT tablosundan okudugu her kayit karsiliginda sistem saatini print eder.

3. Bir row'un islenmesi o gorevin bittigi anlamina gelir. Islenen her row bir daha islenmemelidir. 



EVENT table
- Id
- ? (3. requirementla ilgili bir kolon konulacak)
- creation_date
- modification_date
- version 



http://vichargrave.com/wp-content/uploads/2013/01/producer-consumer-model.png
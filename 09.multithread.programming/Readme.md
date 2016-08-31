1. producer thread: inserts rows into EVENT table. Yapilmasi gereken isleri JOB tablosuna kaydediyor.

2. worker thread: reads from EVENT table. Yapilmasi gereken isleri yapar.

Is: EVENT tablosundan okudugu her kayit karsiliginda sistem saatini print eder.

System.out.println(new Date());

3. Bir row'un islenmesi o gorevin bittigi anlamina gelir. Islenen her row bir daha islenmemelidir. 



JOB table
- Id
- ? (3. requirementla ilgili bir kolon konulacak)
- job_type: (Bu ornekte default olarak her zaman 'print_system_time' olmali.)
- creation_date
- modification_date
- version 



http://vichargrave.com/wp-content/uploads/2013/01/producer-consumer-model.png
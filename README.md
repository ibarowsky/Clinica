# Clinica

Il nostro progetto riguarda una clinica privata che si occupa di effetturare i tamponi ai pazienti e tenere traccia dei positvi e dei negativi, al fine di aiutare la regione campana con dati statistici sul numero dei tamponi, sui postivi e sulla provenienza geografica. 
Ci sono 3 tipi di utenti che possono effetturare il login sulla web app: i pazienti, i medici e l'amminstratore. 
I pazienti si possono registrare sulla web app compilando una form e possono prenotare un tampone semplicemente inviando la richiesta.
I medici possono consultare la lista dei tamponi da eseguire nel seguente giorno e modificare l'esito di un tampone.
L'amministratore può aggiungere o eliminare un medico e inoltre può stampare liste degli esiti al fine di aiutare l'asl nella raccolta dei contagi.
Abbia deciso di sviluppare questo progetto su una web app usando un database mysql e il server apache tomcat.

# Note di Sviluppo
I pattern usati per la creazione di questo progetto sono i seguenti:
- Builder;
- Command;
- State;
- Strategy;
- MVC;

## Builder Pattern
Il Builder Pattern è un pattern creazionale basato su oggetti e viene utilizzato per creare un oggetto senza doverne conoscere i suoi dettagli implementativi.
Questo pattern consente di utilizzare un Client che non debba essere a conoscenza dei passi necessari al fine della creazione di un oggetto ma tali passaggi vengono delegati ad un Director.

### Struttura:
- Director: costruisce un oggetto partendo dall’interfaccia Builder;
- Builder: specifica una interfaccia atta alla creazione del Product;
- ConcreteBuilder: costruisce il Product in base ai metodi definiti nel Builder;
- Product: rappresenta l’oggetto complesso da costruire;

### Implementazione:
É stato usato per il login sulla web app. Dal momento che ci sono 3 tipi diversi di utenti (admin, medico, utente), il builder ci permette di costruire l’interfaccia semplicemente istanziando l’oggetto che identifica il tipo di utente che si sta loggando.

### Diagramma
![database](https://user-images.githubusercontent.com/46711940/109360507-a939fd00-7887-11eb-8415-a91e00623f5b.png)

### Riferimenti di codice:
- [BuilderLogin](https://github.com/ibarowsky/Clinica/blob/main/src/BuilderPattern/BuilderLogin.java).

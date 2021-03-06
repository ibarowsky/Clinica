# Clinica

Il nostro progetto riguarda una clinica privata che si occupa di effetturare i tamponi ai pazienti e tenere traccia dei positvi e dei negativi, al fine di aiutare la regione campana con dati statistici sul numero dei tamponi, sui postivi e sulla provenienza geografica. 
Ci sono 3 tipi di utenti che possono effetturare il login sulla web app: i pazienti, i medici e l'amminstratore. 
I pazienti si possono registrare sulla web app compilando una form e possono prenotare un tampone semplicemente inviando la richiesta.
I medici possono consultare la lista dei tamponi da eseguire nel seguente giorno e modificare l'esito di un tampone.
L'amministratore può aggiungere o eliminare un medico e inoltre può stampare liste degli esiti al fine di aiutare l'asl nella raccolta dei contagi.
Abbia deciso di sviluppare questo progetto su una web app usando un database mysql e il server apache tomcat.

# Note di Sviluppo

## Database
Una persona può specializzarsi in:
- Utente;
- Medico;
- Amministratore;

Una persona può rappresentare una, due o anche tutte e tre le figure sopra citate.
Strutturando il database nel seguente modo abbiamo dato possibilità ad un medico di essere anche amministratore e di poter prenotare un tampone.
La tabella delle prenotazioni tiene tenere traccia di tutti i tamponi effettuati e di quelli ancora da effettuare.
Non possono esserci più di 10 prenotati in un giorno.

La connessione al database viene effettuata tramite il seguente file

[DB](https://github.com/ibarowsky/Clinica/blob/main/src/com/DB.java)

### Diagramma
![database](https://user-images.githubusercontent.com/46711940/109360507-a939fd00-7887-11eb-8415-a91e00623f5b.png)

### Dump
[Dump](https://github.com/ibarowsky/Clinica/blob/main/database/clinica.sql)

## Pattern
I pattern usati per la creazione di questo progetto sono i seguenti:
- MVC;
- Builder;
- Command;
- State;
- Strategy;

## MVC Pattern
Il Model-View-Controller è un pattern architetturale in grado di separare la logica di presentazione dati dalla logica di business.

### Struttura
- View: Si interfaccia con l’utente sia per ricevere le istruzioni, sia per mostrare i risultati.
- Controller: Ricevi le istruzioni impartite dall’utente e li manda al model.
- Model: Fornisce i metodi per accedere ai dati dell’applicazione.

### Implementazione
È stato usato per registrare, eliminare e per fare il login di un utente. 
- Model (Java Beans): incapsula lo stato dell'applicazione memorizzando tutti i dati relativi al programma.
- View (Pagine JSP): Rappresenta l'interfaccia utente gestita attraverso l'utilizzo delle pagine HTML e JSP
- Controller (Servlet): determina il comportamento dell’applicazione implementando le logiche di controllo. Seleziona quale vista presentare all’utente, in funzione delle sue scelte. Favorisce lo scambio di dati tra Model e View.

### Diagramma
![mvc](https://user-images.githubusercontent.com/46711940/109395748-52d3c980-792e-11eb-87cf-dd68dc6d1be2.png)

### Riferimenti al codice
- [com.mvc.bean](https://github.com/ibarowsky/Clinica/tree/main/src/com.mvc.bean)
- [com.mvc.controller](https://github.com/ibarowsky/Clinica/tree/main/src/com.mvc.controller)
- [com.mvc.dao](https://github.com/ibarowsky/Clinica/tree/main/src/com.mvc.dao)

## Builder Pattern
Il Builder Pattern è un pattern creazionale basato su oggetti e viene utilizzato per creare un oggetto senza doverne conoscere i suoi dettagli implementativi.
Questo pattern consente di utilizzare un Client che non debba essere a conoscenza dei passi necessari al fine della creazione di un oggetto ma tali passaggi vengono delegati ad un Director.

### Struttura
- Director: costruisce un oggetto partendo dall’interfaccia Builder;
- Builder: specifica una interfaccia atta alla creazione del Product;
- ConcreteBuilder: costruisce il Product in base ai metodi definiti nel Builder;
- Product: rappresenta l’oggetto complesso da costruire;

### Implementazione
É stato usato per il login sulla web app. Dal momento che ci sono 3 tipi diversi di utenti (admin, medico, utente), il builder ci permette di costruire l’interfaccia semplicemente istanziando l’oggetto che identifica il tipo di utente che si sta loggando.

### Diagramma
![builder](https://user-images.githubusercontent.com/46711940/109393957-ccff5080-7924-11eb-9162-80bba5083e9e.png)

### Riferimenti al codice
- [InterDirector](https://github.com/ibarowsky/Clinica/blob/main/src/BuilderPattern/InterfDirector.java)
- [BuilderLogin](https://github.com/ibarowsky/Clinica/blob/main/src/BuilderPattern/BuilderLogin.java).
- [ConcreteBuilderAdminInterface](https://github.com/ibarowsky/Clinica/blob/main/src/BuilderPattern/ConcreteBuilderAdminInterface.java)
- [ConcreteBuilderMedicoInterface](https://github.com/ibarowsky/Clinica/blob/main/src/BuilderPattern/ConcreteBuilderMedicoInterface.java)
- [ConcreteBuilderUserInterface](https://github.com/ibarowsky/Clinica/blob/main/src/BuilderPattern/ConcreteBuilderUserInterface.java)
- [Interface](https://github.com/ibarowsky/Clinica/blob/main/src/BuilderPattern/Interface.java)

## Command Pattern
Si tratta di un pattern comportamentale basato su oggetti e viene utilizzato quando si ha la necessità di disaccoppiare l’invocazione di un comando dai suoi dettagli implementativi, separando colui che invoca il comando da colui che esegue l’operazione.

### Struttura
- Client: colui che richiede il comando ed imposta il Receiver
- Invoker: colui che effettua l’invocazione del comando
- Command: interfaccia generica per l’esecuzione del comando
- ConcreteCommand: implementazione del comando che consente di collegare l’Invoker con il Receiver
- Reciver: colui che riceve il comando e sa come eseguirlo.

### Implementazione
È stato usato per prenotare un tampone da parte dell’utente. Dal momento che, usando le session siamo in grado di sapere chi ha effettuato la richiesta, è necessario cliccare il tasto “prenota tampone” per invocare il seguente pattern. Il Command Booking si occuperà di trovare una data utile per il tampone, che verrà poi inviata insieme al codice fiscale dell'utente al reciver che si occuperà infine di scrivere la prenotazione su database.

### Diagramma
![Diagramma1](https://user-images.githubusercontent.com/46711940/109394242-4cd9ea80-7926-11eb-9abb-9635429a0ced.png)

### Riferimenti al codice
- [BookingSwab](https://github.com/ibarowsky/Clinica/blob/main/src/CommandPattern/BookingSwab.java)
- [InvokerBooking](https://github.com/ibarowsky/Clinica/blob/main/src/CommandPattern/InvokerBooking.java)
- [Command](https://github.com/ibarowsky/Clinica/blob/main/src/CommandPattern/Command.java)
- [CommandBooking](https://github.com/ibarowsky/Clinica/blob/main/src/CommandPattern/CommandBooking.java)
- [Reciver](https://github.com/ibarowsky/Clinica/blob/main/src/CommandPattern/Reciver.java)

## State Pattern
Si tratta di un pattern comportamentale basato su oggetti che viene utilizzato quando il comportamento di un oggetto deve cambiare in base al suo stato.

### Struttura
- Context: definisce l’interfaccia di interesse del Client e mantiene una instanza della ConcreteState che definisce lo stato corrente
- State: definisce un interfaccia per incapsulare il comportamento associato con un particolare stato.
- ConcreteState: ogni sub-classe che implemento un comportamento associato con uno stato.

### Implementazione
È stato usato per cambiare l’esito dei tamponi da parte del medico. Quest ultimo ha accesso a tutti i tamponi che hanno esito “null” o “in elaborazione”. Ha difatti lui il compito di cambiare l’esito da “null” a “in elaborazione” ai tamponi che sono stati effettivamente fatti e di cambiarli da “in elaborazione” a “positivo” o “negativo” una volta che l'elaborazione del tamone è finito.

### Diagramma
![state](https://user-images.githubusercontent.com/46711940/109395274-cfb17400-792b-11eb-8ab2-55c1bc469f64.png)

### Riferimenti al codice
- [UpdateTampone](https://github.com/ibarowsky/Clinica/blob/main/src/StatePattern/UpdateTampone.java)
- [Tampone](https://github.com/ibarowsky/Clinica/blob/main/src/StatePattern/Tampone.java)
- [Stato](https://github.com/ibarowsky/Clinica/blob/main/src/StatePattern/Stato.java)
- [EsitoInElab](https://github.com/ibarowsky/Clinica/blob/main/src/StatePattern/EsitoInElab.java)
- [EsitoPos](https://github.com/ibarowsky/Clinica/blob/main/src/StatePattern/EsitoPos.java)
- [EsitoNeg](https://github.com/ibarowsky/Clinica/blob/main/src/StatePattern/EsitoNeg.java)

## Strategy Pattern
Si tratta di un pattern comportamentale basato su oggetti e viene utilizzato per definire una famiglia di metodi, incapsularli e renderli intercambiabili.

### Struttura
- Strategy: dichiara una interfaccia che verrà invocata dal Context in base all’algoritmo prescelto
- ConcreteStrategy: effettua l’overwrite del metodo del Context al fine di ritornare l’implementazione dell’algoritmo
- Context: detiene le informazioni di contesto (dati ed algoritmo da utilizzare) ed ha il compito di invocare l’algoritmo

### Implementazione
È stato usato per avere un report da parte del admin. I report possono essere giornalieri, settimanali e mensili. A seconda del report scelto, il metodo al suo interno genererà un file pdf da stampare e inviare all’ASL per la raccolta di informazioni e statistiche dei tamponi. 

### Diagramma
![strategy](https://user-images.githubusercontent.com/46711940/109395552-3daa6b00-792d-11eb-867f-8cc49d7de51c.png)

### Riferimenti al codice
- [Reports](https://github.com/ibarowsky/Clinica/blob/main/src/StrategyPattern/Reports.java)
- [Context](https://github.com/ibarowsky/Clinica/blob/main/src/StrategyPattern/Context.java)
- [StrategyStats](https://github.com/ibarowsky/Clinica/blob/main/src/StrategyPattern/StrategyStats.java)
- [dailyReportStats](https://github.com/ibarowsky/Clinica/blob/main/src/StrategyPattern/dailyReportStats.java)
- [weeklyReportStats](https://github.com/ibarowsky/Clinica/blob/main/src/StrategyPattern/weeklyReportStats.java)
- [monthlyReportStats](https://github.com/ibarowsky/Clinica/blob/main/src/StrategyPattern/monthlyReportStats.java)

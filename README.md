# smsTask


#AktualizacjaSubskrybcji
http://localhost:8080/api/client/updateServiceStatus/8
body: START lub STOP

#Sprwadzenie wszystkich smsów
http://localhost:8080/api/sms/findAll

#Sprawdzenie wszystkich klientów
http://localhost:8080/api/client/findAll

nie wiem z jakiego powodu ale przy próbie uzyskania informacji jakie smsy są przypisane do jakich użytkowników dostaję nieskończoną rekurencyjną serializację , musiałem pominąć ten aspekt w odpowiedzi natomiast wszystko zapisuje się do bazy danych


#Dodanie klienta 
http://localhost:8080/api/client/insert
{
    "id": 0,
    "mobileNumber": 123756775,
    "isServiceUp": true,
    "receivedSms": [],
    "sentSms": []
}

#Wysłanie smsa
http://localhost:8080/api/sms/insert

{
    "sender": {
        "id": 0
    },
    "recipient": {
        "id": 1
    },
    "message": "Hello, this is a test message."
}

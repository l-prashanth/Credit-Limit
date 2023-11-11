package com.prashanth.configuration;


import java.util.ArrayList;
import java.util.List;


import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.BulkWriteOptions;
import com.mongodb.client.model.InsertOneModel;
import com.mongodb.client.model.WriteModel;
import org.bson.Document;
import com.mongodb.MongoClient;
import org.springframework.stereotype.Service;
//import com.mongodb.client.MongoClient;

@Service
public class InsertingMultipleDocuments {
    public void insertmultipledocs() {


        //Creating a MongoDB client
//        try (MongoClient mongo = new MongoClient("localhost", 27017)) {
        try (MongoClient mongo = new MongoClient (new MongoClientURI("mongodb://127.0.0.1:27017"))) {
//           MongoClient mongo = new MongoClient("localhost", 27017);

            //Connecting to the database
            MongoDatabase database = mongo.getDatabase("credit");
            //Creating a collection object
            MongoCollection<Document> collection =
                    database.getCollection("CustomerDetails");
//            BulkWriteOptions options = new BulkWriteOptions();
//            options.ordered(false);

            Document document1 = new Document("name", "Ram").append("age", 26).append("city", "Hyderabad");
//            Document document2 = new Document("name", "Robert").append("age", 27).append("city", "Visakhapatnam");
//            Document document3 = new Document("name", "Rhim").append("age", 30).append("city", "Delhi");
            //Inserting the created documents
            List<Document> list = new ArrayList<Document>();
            list.add(document1);
//            list.add(document2);
//            list.add(document3);
//            collection.insertMany(list);
//            collection.insertMany(list);

            collection.insertMany(list);
            System.out.println("Documents Inserted");
        }
    }
}

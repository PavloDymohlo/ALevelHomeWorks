package ua.dymohlo.mongoandjson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.types.ObjectId;

public class Main {
    public static void main(String[] args) {

        System.out.println(jsonPracticeTestWriteValue());
        jsonPracticeTestReadValue();
        mongoPracticCreatePerson();
        mongoPracticFindingByName();
        mongoPracticFindingById();
        mongoPracticFindingAll();
        mongoPracticUpdateDocument();
        mongoPracticDeleteByName();
        mongoPracticDeleteById();

    }

    private static String jsonPracticeTestWriteValue() {
        ObjectMapper objectMapper = new ObjectMapper();

        JsonPracticeObject jsonPractice = new JsonPracticeObject();
        jsonPractice.setName("Sherlock");
        jsonPractice.setAge(60);
        jsonPractice.setAddress(new String[]{"221b", "Baker St.", "London"});

        String person;
        try {
            person = objectMapper.writeValueAsString(jsonPractice);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return person;
    }

    private static void jsonPracticeTestReadValue() {
        ObjectMapper objectMapper = new ObjectMapper();

        JsonPracticeObject newJsonPractice;
        try {
            newJsonPractice = objectMapper.readValue(jsonPracticeTestWriteValue(), JsonPracticeObject.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        System.out.println(newJsonPractice);

    }

    private static MongoClient mongoClient;

    private static MongoCollection<Document> connectToMongoDB() {
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase database = mongoClient.getDatabase("test");
        return database.getCollection("humans");
    }

    private static void closeMongoDBConnection() {
        if (mongoClient != null) {
            mongoClient.close();
            System.out.println("MongoDB connection closed");
        }
    }

    private static void mongoPracticCreatePerson() {
        try {
            Document doc = new Document("name", "Mr. Robot");
            connectToMongoDB().insertOne(doc);
            System.out.println("The Person is created");
        } finally {
            closeMongoDBConnection();
            System.out.println("The operation is over");
        }
    }

    private static void mongoPracticFindingByName() {
        try {
            FindIterable<Document> documents = connectToMongoDB().find();

            MongoCursor<Document> cursor = documents.iterator();

            while (cursor.hasNext()) {
                Document next = cursor.next();
                String fieldValue = next.getString("name");

                if ("Bruce Dickinson".equals(fieldValue)) {
                    System.out.println(next);
                }
            }
        } finally {
            closeMongoDBConnection();
            System.out.println("The operation is over");
        }
    }

    private static void mongoPracticFindingById() {
        try {
            ObjectId objectId = new ObjectId("658c274ec0ed91694130487e");
            Document query = new Document("_id", objectId);
            Document result = connectToMongoDB().find(query).first();
            if (result != null) {
                System.out.println("Found document: " + result.toJson());
            } else {
                System.out.println("Document not found");
            }
        } finally {
            closeMongoDBConnection();
            System.out.println("The operation is over");
        }
    }

    private static void mongoPracticFindingAll() {
        try {
            FindIterable<Document> documents = connectToMongoDB().find();
            MongoCursor<Document> cursor = documents.cursor();
            while (cursor.hasNext()) {
                Document next = cursor.next();
                System.out.println(next);
            }
        } finally {
            closeMongoDBConnection();
            System.out.println("The operation is over");
        }
    }

    private static void mongoPracticUpdateDocument() {
        try {
            connectToMongoDB().updateOne(
                    Filters.eq("name", "Simple SecondMan"),
                    new Document(
                            "$set", new Document("name", "Garry Potter")
                    )
            );
            System.out.println("Document was updated");
        } finally {
            closeMongoDBConnection();
        }
        System.out.println("The operation is over");
    }

    private static void mongoPracticDeleteByName() {
        try {
            connectToMongoDB().deleteOne(new Document("name", "John Doe"));
            System.out.println("Document was deleted by name.");
        } finally {
            closeMongoDBConnection();
            System.out.println("The operation is over");
        }
    }

    private static void mongoPracticDeleteById() {
        try {
            String idToDelete = "658c14fc6bdf7f2ad647a4dd";
            Document filter = new Document("_id", new ObjectId(idToDelete));
            connectToMongoDB().deleteOne(filter);
            System.out.println("Document was deleted by id.");
        } finally {
            closeMongoDBConnection();
            System.out.println("The operation is over");
        }
    }
}

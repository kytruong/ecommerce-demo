function get_results(result) {
    print(tojson(result));
}

function insert_product(object) {
    print(db.products.insert(object));
}

insert_product({
    "_id": ObjectId("507f1f77bcf86cd799439011"),
    "name": "Product 1",
    "description": "Loren ipsum 1"
});
insert_product({
    "_id": ObjectId("507f191e810c19729de860ea"),
    "name": "Product 2",
    "description": "Loren ipsum 2"
});
insert_product({
    "_id": ObjectId("581d772dfed7620ee89936de"),
    "name": "Product 3",
    "description": "Loren ipsum 3"
});
//pass passsord
print("_______PRODUCTS DATA_______");
db.products.find().forEach(get_results);
print("______END PRODUCTS DATA_____");
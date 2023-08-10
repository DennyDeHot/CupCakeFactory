package com.example.cupcakefactory;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class DBHandler {
    private Context con;
    private DBConnector dbCon;
    private SQLiteDatabase db;

    public DBHandler(Context con) {
        this.con = con;
    }

    public void openDB() {
        this.dbCon = new DBConnector(con);
        this.db = dbCon.getWritableDatabase();
    }


    public User checkUser(User user) {
        try {
            //check whether any record with username=admin and password = 123
            Cursor cursor = db.rawQuery("select * from users where username='" + user.getUsername()
                    + "' and password='" + user.getPassword() + "'", null);

            if (cursor.moveToFirst()) {
                return user;
            } else {
                return null;
            }

        } catch (Exception e) {
            e.getStackTrace();
        }
        return user;
    }

    public User insertUser(User user) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("firstName", user.getFirstName());
        contentValues.put("lastName", user.getLastName());
        contentValues.put("username", user.getUsername());
        contentValues.put("contactNo", user.getContactNo());
        contentValues.put("email", user.getEmail());
        contentValues.put("password", user.getPassword());
        db.insert("users", null, contentValues);
        return user;
    }

    public Cupcake insertCupCake(Cupcake Cupcake) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("cupcakeno", Cupcake.getCupcakeNo());
        contentValues.put("cupcakename", Cupcake.getCupcakeName());
        contentValues.put("quantity", Cupcake.getQuantity());
        contentValues.put("price", Cupcake.getPrice());
        db.insert("Cupcake", null, contentValues);
        return Cupcake;
    }

    public Category insertCategory(Category Category) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("catno", Category.getCatNo());
        contentValues.put("catname", Category.getCatName());
        contentValues.put("catinclude", Category.getCatInclude());
        contentValues.put("catquantity", Category.getCatQuantity());
        contentValues.put("catprice", Category.getCatPrice());
        db.insert("Category", null, contentValues);
        return Category;
    }

    public Cart addToCart(Cart crt) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("uname", crt.getUserN());
        contentValues.put("cname", crt.getCupName());
        contentValues.put("cqty", crt.getQty());
        db.insert("Cart", null, contentValues);
        return crt;
    }

    public List<Cupcake> getAllCupcakeData() {
        List<Cupcake> dataList = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT * FROM Cupcake", null);
        if (cursor != null && cursor.moveToFirst()) {
            do {
                Cupcake model = new Cupcake();
                model.setCupcakeName(cursor.getString(cursor.getColumnIndexOrThrow("cupcakename")));
                model.setPrice(cursor.getString(cursor.getColumnIndexOrThrow("price")));

                dataList.add(model);
            } while (cursor.moveToNext());

        }
        return dataList;
    }

    public List<Category> getAllCategoryData() {
        List<Category> dataList = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT * FROM Category", null);
        if (cursor != null && cursor.moveToFirst()) {
            do {
                Category model = new Category();
                model.setCatName(cursor.getString(cursor.getColumnIndexOrThrow("catname")));
                model.setCatInclude(cursor.getString(cursor.getColumnIndexOrThrow("catinclude")));
                model.setPrice(cursor.getString(cursor.getColumnIndexOrThrow("catprice")));

                dataList.add(model);
            } while (cursor.moveToNext());

        }
        return dataList;
    }

    public List<Cart> getAllCartData() {
        List<Cart> dataList = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT * FROM Cart", null);
        if (cursor != null && cursor.moveToFirst()) {
            do {
                Cart model = new Cart();
                model.setUserN(cursor.getString(cursor.getColumnIndexOrThrow("uname")));
                model.setCupName(cursor.getString(cursor.getColumnIndexOrThrow("cname")));
                model.setQty(cursor.getString(cursor.getColumnIndexOrThrow("cqty")));

                dataList.add(model);
            } while (cursor.moveToNext());

        }
        return dataList;
    }

    public void deleteCartData(String username) {
        //SQLiteDatabase db = this.getWritableDatabase();
        db.delete("Cart", "uname" + "=?", new String[]{username});
        db.close();
    }
}
package data;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import model.CardModel;

@Dao
public interface NewsDao {
    @Query("SELECT * FROM card_table")
    List<CardModel> getAll();

    @Query("DELETE FROM card_table")
    void deleteAll();

    @Insert
    void insert(List<CardModel> news);


    @Update
    void update(CardModel repos);


    @Delete
    void delete(CardModel news);

    @Delete
    void delete(CardModel... news);

}


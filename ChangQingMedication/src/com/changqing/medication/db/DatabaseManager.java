package com.changqing.medication.db;

import java.util.concurrent.atomic.AtomicInteger;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseManager
{
  private static SQLiteOpenHelper _databaseHelper;
  private static DatabaseManager _instance;
  private SQLiteDatabase _database;
  private AtomicInteger _openCounter = new AtomicInteger();

  public static DatabaseManager getInstance()
  {
    try
    {
      if (_instance == null)
        throw new IllegalStateException(DatabaseManager.class.getSimpleName() + " is not initialized, call initializeInstance(..) method first.");
    }
    finally
    {
    }
    DatabaseManager localDatabaseManager = _instance;
    return localDatabaseManager;
  }

  public static void initializeInstance(SQLiteOpenHelper paramSQLiteOpenHelper)
  {
    try
    {
      _databaseHelper = null;
      _databaseHelper = paramSQLiteOpenHelper;
      _instance = null;
      _instance = new DatabaseManager();
      return;
    }
    finally
    {
//      localObject = finally;
//      throw localObject;
    }
  }

  public static boolean isDatabaseExisted(Context paramContext, String paramString)
  {
    return paramContext.getDatabasePath(paramString).exists();
  }

  public void closeDatabase()
  {
    try
    {
      if ((this._openCounter.decrementAndGet() == 0) && (this._database != null))
        this._database.close();
      return;
    }
    finally
    {
//      localObject = finally;
//      throw localObject;
    }
  }

  public boolean isTableExisted(String paramString)
  {
    Cursor localCursor = null;
    boolean bool1 = false;
    if (paramString != null)
    {
      boolean bool2 = "".equals(paramString.trim());
      bool1 = false;
//      if (!bool2)
//        break label28;
    }
    while (true)
    {
      //return bool1;
      String str = "select count(*) as c from sqlite_master where type = 'table' and name = '" + paramString.trim() + "'";
    	  
      try
      {
        localCursor = _databaseHelper.getReadableDatabase().rawQuery(str, null);
        boolean bool4 = localCursor.moveToNext();
        bool1 = false;
        if (bool4)
        {
          int i = localCursor.getInt(0);
          bool1 = false;
          if (i > 0)
            bool1 = true;
        }
        return bool1;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        bool1 = false;
        if (localCursor == null)
          continue;
        boolean bool3 = localCursor.isClosed();
        bool1 = false;
        if (bool3)
          continue;
        localCursor.close();
        return false;
      }
      finally
      {
        if ((localCursor != null) && (!localCursor.isClosed()))
          localCursor.close();
      }
    }
  }

  public SQLiteDatabase readableDatabase()
  {
    try
    {
      if (this._openCounter.incrementAndGet() == 1)
        this._database = _databaseHelper.getReadableDatabase();
      SQLiteDatabase localSQLiteDatabase = this._database;
      return localSQLiteDatabase;
    }
    finally
    {
    }
  }

  public SQLiteDatabase writableDatabase()
  {
    try
    {
      if (this._openCounter.incrementAndGet() == 1)
        this._database = _databaseHelper.getWritableDatabase();
      SQLiteDatabase localSQLiteDatabase = this._database;
      return localSQLiteDatabase;
    }
    finally
    {
    }
  }
}
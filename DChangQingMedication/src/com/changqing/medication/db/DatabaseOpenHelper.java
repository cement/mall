package com.changqing.medication.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseOpenHelper extends SQLiteOpenHelper
{
  private String[] _tableName = null;
  private String[] _tableSQL = null;

  public DatabaseOpenHelper(Context paramContext, String paramString, int paramInt, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    super(paramContext, paramString, null, paramInt);
    String[] arrayOfString = new String[1];
    arrayOfString[0] = ("DatabaseOpenHelper context: " + paramContext + ", databaseName: " + paramString + "; version: " + paramInt + "; sql: " + paramArrayOfString1 + "; tableName: " + paramArrayOfString2);
    //Log.i(arrayOfString);
    this._tableSQL = paramArrayOfString1;
    this._tableName = paramArrayOfString2;
  }

  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    int i = 0;
    String[] arrayOfString1 = new String[1];
    arrayOfString1[0] = ("DatabaseOpenHelper onCreate; _tableSQL: " + this._tableSQL);
   // Log.i(arrayOfString1);
    String[] arrayOfString2;
    int j;
    if ((this._tableSQL != null) && (this._tableSQL.length > 0))
    {
      arrayOfString2 = this._tableSQL;
      j = arrayOfString2.length;
    }
    while (true)
    {
//      if (i >= j)
//        return;
//      String str = arrayOfString2[i];
//      if (str != null)
//        paramSQLiteDatabase.execSQL(str);
      i++;
    }
  }

  public void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    String[] arrayOfString = new String[1];
    arrayOfString[0] = ("DatabaseOpenHelper onDowngrade; _tableSQL: " + this._tableSQL + ", oldVersion: " + paramInt1 + ", newVersion: " + paramInt2);
    //Log.i(getClass().getSimpleName(),arrayOfString);
    onUpgrade(paramSQLiteDatabase, paramInt1, paramInt2);
  }

  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    int i = 0;
    String[] arrayOfString1 = new String[1];
    arrayOfString1[0] = ("DatabaseOpenHelper onUpdate; _tableSQL: " + this._tableSQL + ", oldVersion: " + paramInt1 + ", newVersion: " + paramInt2);
    //Log.i(arrayOfString1);
    String[] arrayOfString2;
    int j;
    if ((this._tableName != null) && (this._tableName.length > 0))
    {
      arrayOfString2 = this._tableName;
      j = arrayOfString2.length;
    }
    while (true)
    {
//      if (i >= j)
//      {
//        onCreate(paramSQLiteDatabase);
//        return;
//      }
//      String str = arrayOfString2[i];
//      if (str != null)
//        paramSQLiteDatabase.execSQL("drop table if exists " + str);
//      i++;
    }
  }
}
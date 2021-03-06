package com.changqing.medication.db.sqlserver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.changqing.medication.db.DatabaseManager;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.content.AsyncTaskLoader;
import android.util.Log;

public class ResultSetLoader extends AsyncTaskLoader<ResultSet> {

	final ForceLoadContentObserver mObserver;

    Uri mUri;
    String[] mProjection;
    String mSelection;
    String[] mSelectionArgs;
    String mSortOrder;

    ResultSet mResultSet;
    Bundle mBundle;
    

    /* Runs on a worker thread */
    @Override
    public ResultSet loadInBackground() {
    	Log.e(getClass().getSimpleName(),Thread.currentThread().getName());
    	ResultSet resultSet = null;
    	Connection connection = null;
    	try {
    	    connection = DatabaseManager.getConnection();
	    	    if(connection!=null){
	    	    	Statement stateMent = connection.createStatement();
	    	    	resultSet = stateMent.executeQuery(mBundle.getString("sql"));
	    	    }
	    	    while (resultSet.next()) {  
		            System.out.println(resultSet.getString(4) + " " + resultSet.getString(6));  
		         }  
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				try {
					if(connection!=null&&!connection.isClosed()){
						connection.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
    	
        return resultSet;
    }

//    @Override
//    public void cancelLoadInBackground() {
//        super.cancelLoadInBackground();
//
//        synchronized (this) {
//            if (mCancellationSignal != null) {
//                mCancellationSignal.cancel();
//            }
//        }
//    }

    /* Runs on the UI thread */
    @Override
    public void deliverResult(ResultSet resultSet) {
    	try {
	        if (isReset()) {
	            // An async query came in while the loader is stopped
	            if (resultSet != null) {
					resultSet.close();
	            }
	            return;
	        }
	        ResultSet oldResult = mResultSet;
	        mResultSet = resultSet;
	
	        if (isStarted()) {
	            super.deliverResult(resultSet);
	        }

			if (oldResult != null && oldResult != resultSet && !oldResult.isClosed()) {
				oldResult.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }

    /**
     * Creates an empty unspecified CursorLoader.  You must follow this with
     * calls to {@link #setUri(Uri)}, {@link #setSelection(String)}, etc
     * to specify the query to perform.
     */
    public ResultSetLoader(Context context) {
        super(context);
        mObserver = new ForceLoadContentObserver();
    }
    public ResultSetLoader(Context context,Bundle bundle) {
    	super(context);
    	mBundle = bundle;
    	mObserver = new ForceLoadContentObserver();
    }

    /**
     * Creates a fully-specified CursorLoader.  See
     * {@link ContentResolver#query(Uri, String[], String, String[], String)
     * ContentResolver.query()} for documentation on the meaning of the
     * parameters.  These will be passed as-is to that call.
     */
    public ResultSetLoader(Context context, Uri uri, String[] projection, String selection,
            String[] selectionArgs, String sortOrder) {
        super(context);
        mObserver = new ForceLoadContentObserver();
        mUri = uri;
        mProjection = projection;
        mSelection = selection;
        mSelectionArgs = selectionArgs;
        mSortOrder = sortOrder;
    }

    /**
     * Starts an asynchronous load of the contacts list data. When the result is ready the callbacks
     * will be called on the UI thread. If a previous load has been completed and is still valid
     * the result may be passed to the callbacks immediately.
     *
     * Must be called from the UI thread
     */
    @Override
    protected void onStartLoading() {
        if (mResultSet != null) {
            deliverResult(mResultSet);
        }
        if (takeContentChanged() || mResultSet == null) {
            forceLoad();
        }
    }

    /**
     * Must be called from the UI thread
     */
    @Override
    protected void onStopLoading() {
        // Attempt to cancel the current load task if possible.
        cancelLoad();
    }

    @Override
    public void onCanceled(ResultSet resultSet) {
        try {
			if (resultSet != null && !resultSet.isClosed()) {
				resultSet.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @Override
    protected void onReset() {
        super.onReset();
        
        // Ensure the loader is stopped
        onStopLoading();

        try {
			if (mResultSet != null && !mResultSet.isClosed()) {
			    mResultSet.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        mResultSet = null;
    }

    public Uri getUri() {
        return mUri;
    }

    public void setUri(Uri uri) {
        mUri = uri;
    }

    public String[] getProjection() {
        return mProjection;
    }

    public void setProjection(String[] projection) {
        mProjection = projection;
    }

    public String getSelection() {
        return mSelection;
    }

    public void setSelection(String selection) {
        mSelection = selection;
    }

    public String[] getSelectionArgs() {
        return mSelectionArgs;
    }

    public void setSelectionArgs(String[] selectionArgs) {
        mSelectionArgs = selectionArgs;
    }

    public String getSortOrder() {
        return mSortOrder;
    }

    public void setSortOrder(String sortOrder) {
        mSortOrder = sortOrder;
    }

//    @Override
//    public void dump(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
//        super.dump(prefix, fd, writer, args);
//        writer.print(prefix); writer.print("mUri="); writer.println(mUri);
//        writer.print(prefix); writer.print("mProjection=");
//                writer.println(Arrays.toString(mProjection));
//        writer.print(prefix); writer.print("mSelection="); writer.println(mSelection);
//        writer.print(prefix); writer.print("mSelectionArgs=");
//                writer.println(Arrays.toString(mSelectionArgs));
//        writer.print(prefix); writer.print("mSortOrder="); writer.println(mSortOrder);
//        writer.print(prefix); writer.print("mCursor="); writer.println(mResultSet);
//        writer.print(prefix); writer.print("mContentChanged="); writer.println(mContentChanged);
//    }
}

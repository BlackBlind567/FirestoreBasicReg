package com.blackblind.firestorebasicreg;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class RetrieveActivity extends AppCompatActivity {

    private static final String TAG = "FireLog";
    private RecyclerView mrecyclerView;
    private FirebaseFirestore firebaseFirestore;
    private List<users> usersList;
    private usersListAdapter musersListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrieve);

        usersList = new ArrayList<>();
        musersListAdapter = new usersListAdapter(usersList);


        mrecyclerView = (RecyclerView) findViewById(R.id.rw_list);
        mrecyclerView.setHasFixedSize(true);
        mrecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mrecyclerView.setAdapter(musersListAdapter);

        firebaseFirestore = FirebaseFirestore.getInstance();

        firebaseFirestore.collection("users").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(QuerySnapshot documentSnapshots, FirebaseFirestoreException e) {

                if (e != null){

                    Log.d(TAG , "Error : " + e.getMessage());
                }

                for (DocumentChange documentChange: documentSnapshots.getDocumentChanges()){

                    switch (documentChange.getType()) {
                        case ADDED:
                            users user = documentChange.getDocument().toObject(users.class);
                            usersList.add(user);
                            musersListAdapter.notifyDataSetChanged();
                            break;
                        case REMOVED:
                            users user1 = documentChange.getDocument().toObject(users.class);
                            usersList.remove(user1);
                            musersListAdapter.notifyDataSetChanged();
                            break;
                        case MODIFIED:
                            users user2 = documentChange.getDocument().toObject(users.class);
                            usersList.getClass();
                            musersListAdapter.notifyDataSetChanged();
                            break;
                    }


//                    if (documentChange.getType() == DocumentChange.Type.ADDED){
//                        users user = documentChange.getDocument().toObject(users.class);
//                        usersList.add(user);
//
//                        musersListAdapter.notifyDataSetChanged();
//                    }

                }

            }
        });

    }
}

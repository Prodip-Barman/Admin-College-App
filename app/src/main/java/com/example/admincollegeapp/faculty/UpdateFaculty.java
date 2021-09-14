package com.example.admincollegeapp.faculty;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.admincollegeapp.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class UpdateFaculty extends AppCompatActivity {

    FloatingActionButton fab;
    RecyclerView csDepartment, aidtDepartment, foodDepartment, racDepartment, mtDepartment;
    LinearLayout csNoData, archNoData, foodNoData, racNoData, mtNoData;
    List<TeacherData> list1, list2, list3, list4, list5;
    TeacherAdapter adapter;

    DatabaseReference reference, dbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_faculty);

        fab = findViewById(R.id.fab);

        csDepartment = findViewById(R.id.csDepartment);
        aidtDepartment = findViewById(R.id.aidtDepartment);
        foodDepartment = findViewById(R.id.foodDepartment);
        racDepartment = findViewById(R.id.racDepartment);
        mtDepartment = findViewById(R.id.mtDepartment);

        csNoData = findViewById(R.id.csNoData);
        archNoData = findViewById(R.id.archNoData);
        foodNoData = findViewById(R.id.foodNoData);
        racNoData = findViewById(R.id.racNoData);
        mtNoData = findViewById(R.id.mtNoData);

        reference = FirebaseDatabase.getInstance().getReference().child("teacher");

        csDepartment();
        aidtDepartment();
        foodDepartment();
        racDepartment();
        mtDepartment();

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UpdateFaculty.this, AddTeacher.class);
                startActivity(intent);
            }
        });
    }

    private void csDepartment() {
        dbRef = reference.child("Computer");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                list1 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    csNoData.setVisibility(View.VISIBLE);
                    csDepartment.setVisibility(View.GONE);
                }else {
                    csNoData.setVisibility(View.GONE);
                    csDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list1.add(data);
                    }
                    csDepartment.setHasFixedSize(true);
                    csDepartment.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter = new TeacherAdapter(list1, UpdateFaculty.this, "Computer");
                    csDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(UpdateFaculty.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void aidtDepartment() {
        dbRef = reference.child("Architecture & Interior Design");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                list2 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    archNoData.setVisibility(View.VISIBLE);
                    aidtDepartment.setVisibility(View.GONE);
                }else {
                    archNoData.setVisibility(View.GONE);
                    aidtDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list2.add(data);
                    }
                    aidtDepartment.setHasFixedSize(true);
                    aidtDepartment.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter = new TeacherAdapter(list2, UpdateFaculty.this, "Architecture & Interior Design");
                    aidtDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(UpdateFaculty.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void foodDepartment() {
        dbRef = reference.child("Food");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                list3 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    foodNoData.setVisibility(View.VISIBLE);
                    foodDepartment.setVisibility(View.GONE);
                }else {
                    foodNoData.setVisibility(View.GONE);
                    foodDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list3.add(data);
                    }
                    foodDepartment.setHasFixedSize(true);
                    foodDepartment.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter = new TeacherAdapter(list3, UpdateFaculty.this, "Food");
                    foodDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(UpdateFaculty.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void racDepartment() {
        dbRef = reference.child("Refrigeration & Air-Conditioning");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                list4 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    racNoData.setVisibility(View.VISIBLE);
                    racDepartment.setVisibility(View.GONE);
                }else {
                    racNoData.setVisibility(View.GONE);
                    racDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list4.add(data);
                    }
                    racDepartment.setHasFixedSize(true);
                    racDepartment.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter = new TeacherAdapter(list4, UpdateFaculty.this, "Refrigeration & Air-Conditioning");
                    racDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(UpdateFaculty.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void mtDepartment() {
        dbRef = reference.child("Mechatronics");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                list5 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    mtNoData.setVisibility(View.VISIBLE);
                    mtDepartment.setVisibility(View.GONE);
                }else {
                    mtNoData.setVisibility(View.GONE);
                    mtDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list5.add(data);
                    }
                    mtDepartment.setHasFixedSize(true);
                    mtDepartment.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter = new TeacherAdapter(list5, UpdateFaculty.this, "Mechatronics");
                    mtDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(UpdateFaculty.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}
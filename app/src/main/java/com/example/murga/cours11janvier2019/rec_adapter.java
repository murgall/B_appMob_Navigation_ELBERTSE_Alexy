package com.example.murga.cours11janvier2019;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class rec_adapter extends RecyclerView.Adapter<rec_adapter.ViewHolder>
    {
    private String[] mDataSet; //Déclarer votre tableau de données




        // Le viewHolder
    public static class ViewHolder extends RecyclerView.ViewHolder
        {
        public TextView mTextView;


            //Constructeur du holder : le viewHolder a une reference vers tous les objets de la liste
        public ViewHolder(View v)
            {
                super(v);
                mTextView = (TextView) v.findViewById(R.id.texte_liste);

            }

        }


        //Constructeur de l'adaptateur : initialisations de l’adapter et des données
        public rec_adapter(String[] monDataset)
        {
            mDataSet = monDataset;
        }


        //Chargement du layout et initialisation du viewHolder
        @Override
        public rec_adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
        {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.ligne_liste, parent, false);
            ViewHolder vh = new ViewHolder(v);
            return vh;
        }


        //Lien entre viewHolder et données
        @Override
        public void onBindViewHolder(ViewHolder holder, final int position)
        {
            holder.mTextView.setText(mDataSet[position]);

        }


        //Nombre d’éléments de la liste
        @Override
        public int getItemCount() {
            return mDataSet.length;
        }


    }

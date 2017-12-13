package com.example.mgota.aad_final;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class CurrencyAdapter extends RecyclerView.Adapter<CurrencyAdapter.ViewHolder>{
    @Override
    public CurrencyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_cell, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CurrencyAdapter.ViewHolder holder, int position) {
        CurrencyModel myCurrency = CurrencyCollection.getCollection().getElements().get(position);
        holder.setup(myCurrency);
    }

    @Override
    public int getItemCount() {
        return CurrencyCollection.getCollection().getElements().size();
    }

    void remove(int pos) {
        CurrencyCollection.getCollection().remove(pos);
        notifyItemRemoved(pos);
    }

    void swap(int posOne, int posTwo) {
        CurrencyCollection.getCollection().swap(posOne, posTwo);
        notifyItemMoved(posOne, posTwo);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private CurrencyModel curr;
        private TextView code, name;
        private ImageView pic;
        private String myCode;

        public ViewHolder(View view){
            super(view);
            view.setOnClickListener(this);
            this.code = view.findViewById(R.id.cellCode);
            this.name = view.findViewById(R.id.cellName);
            this.pic = view.findViewById(R.id.cellPic);
        }

        void setup(CurrencyModel currModel){
            this.curr = currModel;
            this.code.setText(curr.getCode());
            this.name.setText(curr.getName());

            this.myCode = curr.getCode();
            switch(myCode){
                case "USD": this.pic.setImageResource(R.drawable.ic_list_country_us); break;
                case "EUR": this.pic.setImageResource(R.drawable.ic_list_country_eu); break;
                case "JPY": this.pic.setImageResource(R.drawable.ic_list_country_jp); break;
                case "BGN": this.pic.setImageResource(R.drawable.ic_list_country_bg); break;
                case "CZK": this.pic.setImageResource(R.drawable.ic_list_country_cz); break;
                case "DKK": this.pic.setImageResource(R.drawable.ic_list_country_dk); break;
                case "GBP": this.pic.setImageResource(R.drawable.ic_list_country_gb); break;
                case "HUF": this.pic.setImageResource(R.drawable.ic_list_country_hu); break;
                case "PLN": this.pic.setImageResource(R.drawable.ic_list_country_pl); break;
                case "RON": this.pic.setImageResource(R.drawable.ic_list_country_ro); break;
                case "SEK": this.pic.setImageResource(R.drawable.ic_list_country_se); break;
                case "CHF": this.pic.setImageResource(R.drawable.ic_list_country_ch); break;
                case "NOK": this.pic.setImageResource(R.drawable.ic_list_country_no); break;
                case "HRK": this.pic.setImageResource(R.drawable.ic_list_country_hr); break;
                case "RUB": this.pic.setImageResource(R.drawable.ic_list_country_ru); break;
                case "TRY": this.pic.setImageResource(R.drawable.ic_list_country_tr); break;
                case "AUD": this.pic.setImageResource(R.drawable.ic_list_country_au); break;
                case "BRL": this.pic.setImageResource(R.drawable.ic_list_country_br); break;
                case "CAD": this.pic.setImageResource(R.drawable.ic_list_country_ca); break;
                case "CNY": this.pic.setImageResource(R.drawable.ic_list_country_cn); break;
                case "HKD": this.pic.setImageResource(R.drawable.ic_list_country_hk); break;
                case "IDR": this.pic.setImageResource(R.drawable.ic_list_country_id); break;
                case "ILS": this.pic.setImageResource(R.drawable.ic_list_country_il); break;
                case "INR": this.pic.setImageResource(R.drawable.ic_list_country_in); break;
                case "KRW": this.pic.setImageResource(R.drawable.ic_list_country_kr); break;
                case "MXN": this.pic.setImageResource(R.drawable.ic_list_country_mx); break;
                case "MYR": this.pic.setImageResource(R.drawable.ic_list_country_my); break;
                case "NZD": this.pic.setImageResource(R.drawable.ic_list_country_nz); break;
                case "PHP": this.pic.setImageResource(R.drawable.ic_list_country_ph); break;
                case "SGD": this.pic.setImageResource(R.drawable.ic_list_country_sg); break;
                case "THB": this.pic.setImageResource(R.drawable.ic_list_country_th); break;
                case "ZAR": this.pic.setImageResource(R.drawable.ic_list_country_za); break;
            }
        }

        public void onClick(View view){
            Intent intent = new Intent(view.getContext(), CurrencyActivity.class);
            intent.putExtra(CurrencyActivity.myId, this.curr.getId());
            view.getContext().startActivity(intent);
        }
    }
}

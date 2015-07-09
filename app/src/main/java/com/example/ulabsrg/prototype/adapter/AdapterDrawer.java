package com.example.ulabsrg.prototype.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ulabsrg.prototype.R;
import com.example.ulabsrg.prototype.domain.session.Session;
import com.example.ulabsrg.prototype.domain.template.Template;
import com.example.ulabsrg.prototype.domain.user.User;

/**
 * Created by ulabsrg on 08/07/2015.
 */
public class AdapterDrawer extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final Session session;
    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;
    private LayoutInflater inflater;
    private Context context;

    public AdapterDrawer(Context context, Session session) {
        this.session = session;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    public void delete(int position) {
        session.getTemplates().remove(position);
        notifyItemRemoved(position);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_HEADER) {
            View view = inflater.inflate(R.layout.drawer_header, parent, false);
            HeaderHolder holder = new HeaderHolder(view);
            return holder;
        } else {
            View view = inflater.inflate(R.layout.drawer_template_item, parent, false);
            ItemHolder holder = new ItemHolder(view);
            return holder;
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TYPE_HEADER;
        } else {
            return TYPE_ITEM;
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof HeaderHolder) {
            HeaderHolder headerHolder = (HeaderHolder) holder;
            User user = session.getUser();
            headerHolder.tvUserName.setText(user.getName());
            headerHolder.tvUserSurname.setText(user.getSurname());
            headerHolder.tvUserEmail.setText(user.getEmail());
        } else {
            ItemHolder itemHolder = (ItemHolder) holder;
            Object[] templates = session.getTemplates().toArray();
            String templateName = ((Template)templates[position - 1]).getName();
            itemHolder.tvTemplateName.setText(templateName);
        }
    }

    @Override
    public int getItemCount() {
        return session.getTemplates().size() + 1;
    }

    class ItemHolder extends RecyclerView.ViewHolder {
        TextView tvTemplateName;

        public ItemHolder(View itemView) {
            super(itemView);
            tvTemplateName = (TextView) itemView.findViewById(R.id.text_template_name);
        }
    }

    class HeaderHolder extends RecyclerView.ViewHolder {
        TextView tvUserName;
        TextView tvUserSurname;
        TextView tvUserEmail;

        public HeaderHolder(View itemView) {
            super(itemView);
            tvUserName = (TextView) itemView.findViewById(R.id.text_user_name);
            tvUserSurname = (TextView) itemView.findViewById(R.id.text_user_surname);
            tvUserEmail = (TextView) itemView.findViewById(R.id.text_user_email);
        }
    }
}

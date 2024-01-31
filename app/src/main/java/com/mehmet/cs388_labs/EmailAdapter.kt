package com.mehmet.cs388_labs

import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class EmailAdapter(private val emails: List<Email>) : RecyclerView.Adapter<EmailAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val senderTextView: TextView = itemView.findViewById(R.id.senderTextView)
        val titleTextView: TextView = itemView.findViewById(R.id.titleTextView)
        val summaryTextView: TextView = itemView.findViewById(R.id.summaryTextView)
        val avatarImageView: ImageView = itemView.findViewById(R.id.avatarImageView)
        val dateTextView: TextView = itemView.findViewById(R.id.dateTextView)

        init {
            itemView.setOnClickListener {
                senderTextView.setTypeface(null, Typeface.NORMAL)
                titleTextView.setTypeface(null, Typeface.NORMAL)
                summaryTextView.setTypeface(null, Typeface.NORMAL)
                dateTextView.setTypeface(null, Typeface.NORMAL)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val contactView = inflater.inflate(R.layout.email_item, parent, false)
        return ViewHolder(contactView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val email = emails[position]
        holder.senderTextView.text = email.sender
        holder.titleTextView.text = email.title
        holder.summaryTextView.text = email.summary
        holder.avatarImageView.setImageResource(email.avatar)
        holder.dateTextView.text = "Today"
    }

    override fun getItemCount(): Int {
        return emails.size
    }
}
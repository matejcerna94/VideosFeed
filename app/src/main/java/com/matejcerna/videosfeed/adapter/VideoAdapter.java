package com.matejcerna.videosfeed.adapter;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.VideoView;

import com.matejcerna.videosfeed.R;
import com.matejcerna.videosfeed.activity.SecondActivity;
import com.matejcerna.videosfeed.model.Video;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.VideoViewHolder> {

    private Context context;
    private Video[] data;
    private int stop_position;

    public VideoAdapter(Context context, Video[] data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public VideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_video_layout, parent, false);
        return new VideoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final VideoViewHolder holder, int position) {
        final Video video = data[position];
        holder.textViewDescription.setText(video.getDescription());
        holder.textViewAuthor.setText(video.getAuthor().getName());
        holder.textViewCreatedBefore.setText(video.getCreatedBefore());
        holder.videoView.setVideoPath(video.getVideo().getUrl());

        holder.videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                holder.videoView.start();
                mediaPlayer.setVolume(0, 0);
            }
        });

        holder.itemView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() {
            @Override
            public void onViewAttachedToWindow(View view) {
                holder.videoView.seekTo(stop_position);
                holder.videoView.start();
                //Toast.makeText(context, video.getDescription() + " attached", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onViewDetachedFromWindow(View view) {
                stop_position = holder.videoView.getCurrentPosition();
                holder.videoView.pause();
                //Toast.makeText(context, video.getDescription() + " recycled", Toast.LENGTH_SHORT).show();
            }
        });


        holder.videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                mediaPlayer.reset();
                holder.videoView.setVideoPath(video.getVideo().getUrl());
                holder.videoView.start();
            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), SecondActivity.class);
                intent.putExtra("video_url", video.getVideo().getUrl());
                view.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class VideoViewHolder extends RecyclerView.ViewHolder {
        VideoView videoView;
        TextView textViewDescription;
        TextView textViewAuthor;
        TextView textViewCreatedBefore;

        public VideoViewHolder(@NonNull View itemView) {
            super(itemView);
            videoView = itemView.findViewById(R.id.video_view);
            textViewDescription = itemView.findViewById(R.id.text_view_description);
            textViewAuthor = itemView.findViewById(R.id.text_view_author);
            textViewCreatedBefore = itemView.findViewById(R.id.created_before_text_view);
        }
    }
}

package fr.ugatir.cda1_android;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class RoomAdapter extends RecyclerView.Adapter<RoomAdapter.RoomViewHolder> {

    private List<Room> roomList;
    private LayoutInflater inflater;

    public RoomAdapter(Context context, List<Room> roomList) {
        this.inflater = LayoutInflater.from(context);
        this.roomList = roomList;
    }

    @NonNull
    @Override
    public RoomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.item_room, parent, false);
        return new RoomViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RoomViewHolder holder, int position) {
        Room currentRoom = roomList.get(position);
        holder.roomNameTextView.setText(currentRoom.getName());
        holder.roomAddressTextView.setText(currentRoom.getAddress());
        // Plus de propriétés peuvent être assignées ici selon votre item_room.xml
    }

    @Override
    public int getItemCount() {
        return roomList.size();
    }

    class RoomViewHolder extends RecyclerView.ViewHolder {
        private TextView roomNameTextView;
        private TextView roomAddressTextView;

        RoomViewHolder(View itemView) {
            super(itemView);
            roomNameTextView = itemView.findViewById(R.id.tv_room_name);
            roomAddressTextView = itemView.findViewById(R.id.tv_room_address);
            // Initialiser plus de vues de itemView ici si nécessaire
        }
    }
}

package com.crossover.assignment.jitenshasaitama.nearbyplaces;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.crossover.assignment.jitenshasaitama.R;
import com.crossover.assignment.jitenshasaitama.data.Bikes;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link NearByPlacesFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link NearByPlacesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NearByPlacesFragment extends Fragment {

    private OnFragmentInteractionListener mListener;
    private NearByPlacesAdapter mListAdapter;

    public NearByPlacesFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static NearByPlacesFragment newInstance() {
        NearByPlacesFragment fragment = new NearByPlacesFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // mListAdapter = new NearByPlacesAdapter(new ArrayList<Bikes>(0), mItemListener);
        //mActionsListener = new NotesPresenter(Injection.provideNotesRepository(), this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_near_by_places, container, false);
        RecyclerView recyclerView = (RecyclerView) root.findViewById(R.id.recycler_view);
        recyclerView.setAdapter(mListAdapter);


        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));



        return root;
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    /**
     * Listener for clicks on Bike in the RecyclerView.
     */
    NearByPlacesFragment.BikeItemListener mItemListener = new NearByPlacesFragment.BikeItemListener() {
        @Override
        public void onBikeItemClicked(Bikes clickedBikeDetail) {

        }
    };

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }

    public  interface BikeItemListener{
        void onBikeItemClicked(Bikes bike);
    }
}

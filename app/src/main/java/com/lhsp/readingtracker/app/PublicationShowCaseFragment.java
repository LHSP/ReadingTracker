package com.lhsp.readingtracker.app;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lhsp.readingtracker.R;

/**
 * Created by LHSP on 24/03/14.
 */
public class PublicationShowCaseFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    public PublicationShowCaseFragment() {
    }

    public static PublicationShowCaseFragment newInstance(int sectionNumber) {
        PublicationShowCaseFragment fragment = new PublicationShowCaseFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber - 1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_publication_showcase, container, false);

        int sectionNumber = getArguments().getInt(ARG_SECTION_NUMBER);
        Publication publication = PublicationList.getMyPublications().get(sectionNumber < 0 ? 0 : sectionNumber);

        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        ((ReadingTracker) activity).onSectionAttached(
                getArguments().getInt(ARG_SECTION_NUMBER));
    }
}

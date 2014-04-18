package com.lhsp.readingtracker.app;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lhsp.readingtracker.R;

/**
 * Created by LHSP on 24/03/14.
 */
public class PublicationFragment extends Fragment{
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PublicationFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PublicationFragment newInstance(int sectionNumber) {
            PublicationFragment fragment = new PublicationFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber - 1);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_publication_detail, container, false);

            int sectionNumber = getArguments().getInt(ARG_SECTION_NUMBER);
            Publication publication = PublicationList.getMyPublications().get(sectionNumber < 0 ? 0 : sectionNumber);

            // Shows the Title and Description of the Publication
            TextView tvEditionTitle = (TextView)rootView.findViewById(R.id.tvTitle);
            tvEditionTitle.setText(publication.title);
            TextView tvDescription = (TextView) rootView.findViewById(R.id.tvDescription);
            tvDescription.setMovementMethod(new ScrollingMovementMethod());
            tvDescription.setText(publication.description);

            // Shows the Editions of the Publication
            Edition[] editions = publication.editions;

            EditionAdapter editionAdapter = new EditionAdapter(this.getActivity(), R.layout.listview_editions_row, editions);
            LinearLayout editionList = (LinearLayout) rootView.findViewById(R.id.llEditions);

            final int adapterCount = editionAdapter.getCount();

            for (int i = 0; i < adapterCount; i++) {
                View item = editionAdapter.getView(i, null, null);
                editionList.addView(item);
            }

            return rootView;
        }

        @Override
        public void onAttach(Activity activity) {
            super.onAttach(activity);
            ((ReadingTracker) activity).onSectionAttached(
                    getArguments().getInt(ARG_SECTION_NUMBER));
        }
}

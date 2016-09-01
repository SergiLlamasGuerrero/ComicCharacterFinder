package finder.character.comic.comiccharacterfinder.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import finder.character.comic.comiccharacterfinder.R;
import finder.character.comic.comiccharacterfinder.comicsList.ComicsListFragment;

/**
 * Created by sllamas on 29/8/16.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, new ComicsListFragment());
        fragmentTransaction.commit();
    }

}

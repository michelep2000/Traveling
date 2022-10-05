package es.travelworld.traveling.login;

import android.annotation.SuppressLint;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import es.travelworld.traveling.models.User;

@SuppressLint("StaticFieldLeak")
public class LoginViewModel extends ViewModel {
    private final LoginRepository loginRepository;
    private final Context context;
    private final MutableLiveData<User> _user = new MutableLiveData<>();


    public LoginViewModel(LoginRepository loginRepository, Context context) {
        this.loginRepository = loginRepository;
        this.context = context;
    }

    public void login(String username, String password) {
        loginRepository.login(username, password, new LoginRepository.Login() {
            @Override
            public void onSuccess(User user) {
                _user.setValue(user);
            }

            @Override
            public void onError(Throwable exc) {

            }
        });
    }

    public LiveData<User> getUser() {
        return _user;
    }

    public static class Factory extends ViewModelProvider.NewInstanceFactory {
        private final LoginRepository loginRepository;
        private final Context applicationContext;

        public Factory(LoginRepository loginRepository, Context applicationContext) {
            this.loginRepository = loginRepository;
            this.applicationContext = applicationContext;
        }

        public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
            return (T) new LoginViewModel(loginRepository, applicationContext);
        }
    }
}


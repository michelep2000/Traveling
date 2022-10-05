package es.travelworld.traveling.login;


import es.travelworld.traveling.models.User;
import es.travelworld.traveling.repository.RetrofitFactory;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginRepository {

    interface Login {
        void onSuccess(User user);

        void onError(Throwable exc);
    }

    public void login(String username, String password, Login callback) {
        RetrofitFactory.getMockPstmnApi().login(username, password).enqueue(
                new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        if (response.code() == 200) callback.onSuccess(response.body());
                        else callback.onSuccess(null);
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                        callback.onError(t);
                    }
                }
        );
    }
}



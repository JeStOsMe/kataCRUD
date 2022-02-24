import React, {createContext, useContext, useReducer} from 'react';

const HOST_API = 'http://localhost:8080/api';

const initialState = {
  list: []
};

const Store = createContext(initialState);

const List = () => {
  
  const {dispatch, state} = useContext(Store);

  return (
    <div>
      <table>
        <thead>
          <tr>
            <td>ID</td>
            <td>Nombre</td>
            <td>¿Está completado?</td>
          </tr>
        </thead>
        <tbody>
          {state.list.map((todo) => {
            return <tr key={todo.id}>
              <td>{todo.id}</td>
              <td>{todo.name}</td>
              <td>{todo.isCompleted}</td>
            </tr>
          })}
        </tbody>
      </table>
    </div>
  );
}

const StoreProvider = ( {children}) => {
  function reducer(state, action) {
    switch (action.type) {
      case 'update-list':
        return {...state, list: action.list}
      case 'add-item':
        const newList = state.list;
        newList.push(action.item);
        return {...state, list: newList}
      default:
        return state;
    }
  }

  const [state, dispatch] = useReducer(reducer, initialState);

  return <Store.Provider value={{state, dispatch}}>
    {children}
  </Store.Provider>

}



function App() {
  return (
    <div>
      
    </div>
  );
}

export default App;

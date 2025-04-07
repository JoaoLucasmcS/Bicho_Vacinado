import { Routes, Route } from 'react-router-dom';

import Home from '@pages/Home';
import Pets from '@/pages/Pets';
import PetEdit from '@/pages/PetEdit';

const AppRoutes = () => {
  return (
    <Routes>
      <Route
        path="/"
        element={<Home />}
      />

      <Route
        path="/pets"
        element={<Pets />}
      />

      <Route
        path="/petedit/:id"
        element={<PetEdit />}
      />
    </Routes>
  )
}

export default AppRoutes;
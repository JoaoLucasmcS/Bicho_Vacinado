import { Routes, Route } from 'react-router-dom';

import Home from '@pages/Home';
import Pets from '@/pages/Pets';
import PetInfo from '@/pages/PetInfo';

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
        path="/pets/:id"
        element={<PetInfo />}
      />
    </Routes>
  )
}

export default AppRoutes;
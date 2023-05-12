package com.teamproject.devTalks.repository.recommendation;

import com.teamproject.devTalks.entity.primaryKey.recommendation.RecommendationPk;
import com.teamproject.devTalks.entity.recommendation.RecommendationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecommendationRepository extends JpaRepository<RecommendationEntity, RecommendationPk> {

    RecommendationEntity findBySenderUserNumberAndReceiverUserNumber(int senderId,int receiverId);

}
